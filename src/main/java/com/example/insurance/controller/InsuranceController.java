package com.example.insurance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.insurance.model.User;
import com.example.insurance.model.UserDetail;
import com.example.insurance.model.contract.Contract;
import com.example.insurance.model.contract.PropertyInsurance;
import com.example.insurance.model.contract.TravelInsurance;
import com.example.insurance.repository.ContractRepository;
import com.example.insurance.repository.UserRepository;

@RestController
public class InsuranceController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	ContractRepository<TravelInsurance> travelInsuranceRepository;
	@Autowired
	ContractRepository<PropertyInsurance> propertyInsuranceRepository;	

	
	@GetMapping("/insured")
	public ResponseEntity<List<User>> getAll() {
		try {
			List<User> users = new ArrayList<User>();
			userRepository.findAll(Sort.by(Sort.Direction.ASC, "surname")).forEach(users::add);
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insured")
	public ResponseEntity<Long> createUser(@RequestBody User user) {
		try {
			System.out.println(user);
			User newUser = userRepository.save(user);
			return new ResponseEntity<>(newUser.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/insured/{id}")
	public ResponseEntity<UserDetail> getUserDetail(@PathVariable("id") long id) {
		try {
			Optional<User> userData = userRepository.findById(id);
			if (userData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			UserDetail userDetail = new UserDetail(userData.get());
			List<Contract> contracts = new ArrayList<>();
			travelInsuranceRepository.findByUserId(userDetail.getId()).forEach(contracts::add);
			propertyInsuranceRepository.findByUserId(userDetail.getId()).forEach(contracts::add);
			userDetail.setContracts(contracts);
			return new ResponseEntity<>(userDetail, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/insured/{id}/travel-insurance")
	public ResponseEntity<Long> createTravelInsurance(@PathVariable("id") long id, @RequestBody TravelInsurance travelInsurance) {
		try {
			System.out.println(travelInsurance);
			Optional<User> userData = userRepository.findById(id);
			if (userData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
			}
			travelInsurance.setUser(userData.get());
			TravelInsurance newTravelInsurance = travelInsuranceRepository.save(travelInsurance);
			
			return new ResponseEntity<>(newTravelInsurance.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insured/{id}/property-insurance")
	public ResponseEntity<Long> createPropertyInsurance(@PathVariable("id") long id, @RequestBody PropertyInsurance propertyInsurance) {
		try {
			System.out.println(propertyInsurance);
			Optional<User> userData = userRepository.findById(id);
			if (userData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
			}
			propertyInsurance.setUser(userData.get());
			PropertyInsurance newPropertyInsurance = propertyInsuranceRepository.save(propertyInsurance);
			
			return new ResponseEntity<>(newPropertyInsurance.getId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

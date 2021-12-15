package com.example.insurance.model;

import java.util.List;

import com.example.insurance.model.contract.Contract;

public class UserDetail extends User {
	private List<Contract> contracts;

	public UserDetail(User user) {
		super(user.getId(), user.getName(), user.getSurname(), user.getPersonalIdNumber(), user.getEmail(), user.getPermanent(), user.getCorrespondence());		
	}	
	
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
}

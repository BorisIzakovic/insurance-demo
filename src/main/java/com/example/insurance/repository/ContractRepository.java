package com.example.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.insurance.model.contract.Contract;

@NoRepositoryBean
public interface ContractRepository<T extends Contract> extends JpaRepository<T, Long> {
	List<Contract> findByUserId(Long userId);
}

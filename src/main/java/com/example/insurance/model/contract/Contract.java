package com.example.insurance.model.contract;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.example.insurance.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@PastOrPresent
	protected LocalDate issueDate;
	@ManyToOne
	@NotNull
	@JoinColumn(name="user_id")
	@JsonIgnore
	protected User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

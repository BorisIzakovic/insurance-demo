package com.example.insurance.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "Surname is required")
	private String surname;
	@NotEmpty
	private String personalIdNumber;
	@Email(message = "Email must be valid")
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	@NotNull
	private Address permanent;
	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	private Address correspondence;

	public User() {
	}
	
	public User(Long id, @NotEmpty(message = "Name is required") String name,
			@NotEmpty(message = "Surname is required") String surname, @NotEmpty String personalIdNumber,
			@Email(message = "Email must be valid") String email, @Valid @NotNull Address permanent,
			@Valid Address correspondence) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.personalIdNumber = personalIdNumber;
		this.email = email;
		this.permanent = permanent;
		this.correspondence = correspondence;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPersonalIdNumber() {
		return personalIdNumber;
	}

	public void setPersonalIdNumber(String personalIdNumber) {
		this.personalIdNumber = personalIdNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getPermanent() {
		return permanent;
	}

	public void setPermanent(Address permanent) {
		this.permanent = permanent;
	}

	public Address getCorrespondence() {
		return correspondence;
	}

	public void setCorrespondence(Address correspondence) {
		this.correspondence = correspondence;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", personalIdNumber=" + personalIdNumber
				+ ", email=" + email + ", permanent=" + permanent + ", correspondence=" + correspondence + "]";
	}
}

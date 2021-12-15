package com.example.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;	
    @NotEmpty
    private String street;
    @NotEmpty
    private String  houseNumber;
    @NotEmpty
    private String city;
    @NotEmpty
    private String postalcode;

    public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	@Override
    public String toString() {
        return
                " street: " + street +
                        " | houseNumber: " + houseNumber +
                        " | city:" + city +
                        " | postalcode: " + postalcode;
    }
}

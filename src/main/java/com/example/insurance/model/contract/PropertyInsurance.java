package com.example.insurance.model.contract;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.insurance.model.Address;

@Entity
public class PropertyInsurance extends Contract {
    @OneToOne(cascade = CascadeType.ALL)
	protected Address propertyAddress;
    @Positive
    protected double propertyValue;
    @NotNull
    protected PropertyType propertyType;

	public Address getPropertyAddress() {
		return propertyAddress;
	}

	public double getPropertyValue() {
		return propertyValue;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyAddress(Address propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public void setPropertyValue(double propertyValue) {
		this.propertyValue = propertyValue;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
}

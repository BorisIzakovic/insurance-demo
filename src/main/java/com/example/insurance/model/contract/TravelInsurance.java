package com.example.insurance.model.contract;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class TravelInsurance extends Contract {
	@NotNull
	protected LocalDate insuranceStart;
	@NotNull
	protected LocalDate insuranceEnd;
	protected boolean damage;
	protected boolean injury;

	public LocalDate getInsuranceStart() {
		return insuranceStart;
	}

	public void setInsuranceStart(LocalDate insuranceStart) {
		this.insuranceStart = insuranceStart;
	}

	public LocalDate getInsuranceEnd() {
		return insuranceEnd;
	}

	public void setInsuranceEnd(LocalDate insuranceEnd) {
		this.insuranceEnd = insuranceEnd;
	}

	public boolean isDamage() {
		return damage;
	}

	public void setDamage(boolean damage) {
		this.damage = damage;
	}

	public boolean isInjury() {
		return injury;
	}

	public void setInjury(boolean injury) {
		this.injury = injury;
	}
}

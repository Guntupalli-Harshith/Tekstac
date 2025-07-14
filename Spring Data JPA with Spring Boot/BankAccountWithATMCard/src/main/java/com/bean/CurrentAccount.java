package com.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("CURR")
public class CurrentAccount extends Account {
	private double ODLimit;

	public CurrentAccount() {
	}

	public double getODLimit() {
		return ODLimit;
	}

	public void setODLimit(double ODLimit) {
		this.ODLimit = ODLimit;
	}
}
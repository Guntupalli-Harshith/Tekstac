package com.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("SAV")
public class SavingsAccount extends Account {
	
	private double minimumBalance;

	public SavingsAccount() {
		
	}
	
	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
}
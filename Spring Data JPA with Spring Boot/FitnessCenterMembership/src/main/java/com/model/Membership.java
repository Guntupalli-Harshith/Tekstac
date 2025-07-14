package com.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "membership")
public class Membership {

    @Id
    @NotBlank(message = "Provide value for membership Id")
    @Column(name = "membership_id")
    private String membershipId;
    
    @NotBlank(message = "Provide value for plan name")
    @Column(name = "plan_name")
    private String planName;
    
    @NotBlank(message = "Provide value for membership type")
    @Column(name = "membership_type")
    private String membershipType;
    
    @Min(value = 30, message = "Monthly Access Hours should be in the range 30 to 90")
    @Max(value = 90, message = "Monthly Access Hours should be in the range 30 to 90")
    @Column(name = "monthly_access_hours")
    private int monthlyAccessHours;
    
    @PastOrPresent(message = "Launch date should be either current or past date")
    @Column(name = "launch_date")
    private LocalDate launchDate;
    
    @Future(message = "Expiration date should be in future")
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    
    @Positive(message = "Monthly fee should be greater than zero")
    @Column(name = "monthly_fee")
    private double monthlyFee;
    
    @NotBlank(message = "Provide value for benefits")
    @Column(name = "benefits")
    private String benefits;
    
    @Column(name = "diet_plan_opted")
    private boolean dietPlanOpted;

    // Default constructor
    public Membership() {
        super();
    }

    // All-args constructor
    public Membership(String membershipId, String planName, String membershipType, int monthlyAccessHours,
            LocalDate launchDate, LocalDate expirationDate, double monthlyFee, String benefits, boolean dietPlanOpted) {
        this.membershipId = membershipId;
        this.planName = planName;
        this.membershipType = membershipType;
        this.monthlyAccessHours = monthlyAccessHours;
        this.launchDate = launchDate;
        this.expirationDate = expirationDate;
        this.monthlyFee = monthlyFee;
        this.benefits = benefits;
        this.dietPlanOpted = dietPlanOpted;
    }

    // Getters and Setters
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public int getMonthlyAccessHours() {
        return monthlyAccessHours;
    }

    public void setMonthlyAccessHours(int monthlyAccessHours) {
        this.monthlyAccessHours = monthlyAccessHours;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public boolean isDietPlanOpted() {
        return dietPlanOpted;
    }

    public void setDietPlanOpted(boolean dietPlanOpted) {
        this.dietPlanOpted = dietPlanOpted;
    }
}
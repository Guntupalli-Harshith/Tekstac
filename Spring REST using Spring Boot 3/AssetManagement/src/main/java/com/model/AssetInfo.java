package com.model;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

public class AssetInfo {
    
    @Positive(message = "Asset ID must be a positive number")
    
    
    private int assetId;  
    @NotBlank(message = "Provide value for asset name")
    @Size(min = 2, max = 100, message = "Asset name must be between 2 and 100 characters")
    private String assetName;
    @NotBlank(message = "Provide value for asset type")
    @Pattern(regexp = "VEHICLE|ELECTRONIC|FURNITURE|SOFTWARE|HARDWARE", message = "Asset type must be one of VEHICLE,ELECTRONIC,FURNITURE,SOFTWARE,HARDWARE")
    private String assetType;
    
    
    //VEHICLE, ELECTRONIC, FURNITURE, SOFTWARE, HARDWARE
    @NotBlank(message = "Provide value for assigned person")
    @Size(min = 2, max = 50, message = "Assigned person's name must be between 2 and 50 characters")
    private String assignedTo;
    
    @PastOrPresent(message = "Purchase date cannot be in the future")
    
    private LocalDate purchaseDate;
    
    @Positive(message = "Asset value must be greater than zero")
    private double assetValue;
    private boolean isOperational;
    
    @NotBlank(message = "Provide value for asset condition")
    @Pattern(regexp = "NEW|GOOD|NEEDS_REPAIR|DAMAGED|DISPOSED",message="Asset condition must be one of NEW,GOOD,NEEDS_REPAIR,DAMAGED,DISPOSED")
    private String assetCondition;
    
    //NEW, GOOD, NEEDS_REPAIR, DAMAGED, DISPOSED
    
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public double getAssetValue() {
		return assetValue;
	}
	public void setAssetValue(double assetValue) {
		this.assetValue = assetValue;
	}
	public boolean isOperational() {
		return isOperational;
	}
	public void setOperational(boolean isOperational) {
		this.isOperational = isOperational;
	}
	public String getAssetCondition() {
		return assetCondition;
	}
	public void setAssetCondition(String assetCondition) {
		this.assetCondition = assetCondition;
	}
	
	public AssetInfo() {
		
	}
	public AssetInfo(int assetId, String assetName, String assetType, String assignedTo, LocalDate purchaseDate,
			double assetValue, boolean isOperational, String assetCondition) {
		super();
		this.assetId = assetId;
		this.assetName = assetName;
		this.assetType = assetType;
		this.assignedTo = assignedTo;
		this.purchaseDate = purchaseDate;
		this.assetValue = assetValue;
		this.isOperational = isOperational;
		this.assetCondition = assetCondition;
	}
	
	
	
    
    
    
}
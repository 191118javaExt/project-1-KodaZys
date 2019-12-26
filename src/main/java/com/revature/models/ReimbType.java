package com.revature.models;

public class ReimbType {
	
	private int reimbTypeId;
	private String reimbType;
	
	// Reimbursement Type can be:
	// 1 => LODGING
	// 2 => TRAVEL
	// 3 => FOOD
	// 4 => OTHER
	
	public ReimbType() {};
	
	public ReimbType(int reimbTypeId, String reimbType) {
		super();
		this.reimbTypeId = reimbTypeId;
		this.reimbType = reimbType;
	}

	public int getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "ReimbType [reimbTypeId = " + reimbTypeId + ", reimbType = " + reimbType + "]";
	}
	
	
	
}

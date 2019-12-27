package com.revature.models;

public class ReimbStatus {
	private int statusId;
	private String statusWord;
	
	public ReimbStatus() {}

	public ReimbStatus(int statusId, String statusWord) {
		super();
		this.statusId = statusId;
		this.statusWord = statusWord;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusWord() {
		return statusWord;
	}

	public void setStatusWord(String statusWord) {
		this.statusWord = statusWord;
	}

	@Override
	public String toString() {
		return "ReimbStatus [statusId=" + statusId + ", statusWord=" + statusWord + "]";
	};
	
}

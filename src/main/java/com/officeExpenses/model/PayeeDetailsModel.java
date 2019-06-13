package com.officeExpenses.model;

public class PayeeDetailsModel {
	private long id;
	private String payeeName;
	private String otherDetails;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	
	public PayeeDetailsModel() {
		id = 0;
	}
	public PayeeDetailsModel(long id, String payeeName, String otherDetails) {
		super();
		this.id = id;
		this.payeeName = payeeName;
		this.otherDetails = otherDetails;
	}
	@Override
	public String toString() {
		return "PayeeDetailsModel [id=" + id + ", payeeName=" + payeeName + ", otherDetails=" + otherDetails + "]";
	}
	
	
}

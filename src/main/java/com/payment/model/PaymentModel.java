package com.payment.model;

public class PaymentModel {

	private int paymentid;
	private String schemeId;
	private String mobileNumber;
	private String paymentType;
	private int amount;
	private String paymentDate;
	private String description;
	private String paymentSuccess;
	
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public String getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPaymentSuccess() {
		return paymentSuccess;
	}
	public void setPaymentSuccess(String paymentSuccess) {
		this.paymentSuccess = paymentSuccess;
	}
	@Override
	public String toString() {
		return "PaymentModel [paymentid=" + paymentid + ", schemeId=" + schemeId + ", mobileNumber=" + mobileNumber
				+ ", paymentType=" + paymentType + ", amount=" + amount + ", paymentDate=" + paymentDate
				+ ", description=" + description + ", paymentSuccess=" + paymentSuccess + "]";
	}
	
	
	
	
}

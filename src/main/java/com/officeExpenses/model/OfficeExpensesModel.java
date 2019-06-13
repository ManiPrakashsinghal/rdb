package com.officeExpenses.model;

public class OfficeExpensesModel {
	private int oedId;
	private String payeeName;
	private int payeeNameId;
	private int amount;
	private String oedDate;
	private String discription;
	private String inOutExpenses;
	public int getOedId() {
		return oedId;
	}
	public void setOedId(int oedId) {
		this.oedId = oedId;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public int getPayeeNameId() {
		return payeeNameId;
	}
	public void setPayeeNameId(int payeeNameId) {
		this.payeeNameId = payeeNameId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getOedDate() {
		return oedDate;
	}
	public void setOedDate(String oedDate) {
		this.oedDate = oedDate;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getInOutExpenses() {
		return inOutExpenses;
	}
	public void setInOutExpenses(String inOutExpenses) {
		this.inOutExpenses = inOutExpenses;
	}
	@Override
	public String toString() {
		return "OfficeExpensesModel [oedId=" + oedId + ", payeeName=" + payeeName + ", payeeNameId=" + payeeNameId
				+ ", amount=" + amount + ", oedDate=" + oedDate + ", discription=" + discription + ", inOutExpenses="
				+ inOutExpenses + "]";
	}
	
	
	
}

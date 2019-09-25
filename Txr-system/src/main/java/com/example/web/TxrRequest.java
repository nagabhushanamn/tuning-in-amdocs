package com.example.web;

public class TxrRequest {

	private int id;
	private double amount;
	private String fromAccNum;
	private String toAccNum;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFromAccNum() {
		return fromAccNum;
	}

	public void setFromAccNum(String fromAccNum) {
		this.fromAccNum = fromAccNum;
	}

	public String getToAccNum() {
		return toAccNum;
	}

	public void setToAccNum(String toAccNum) {
		this.toAccNum = toAccNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TxrRequest [id=" + id + ", amount=" + amount + ", fromAccNum=" + fromAccNum + ", toAccNum=" + toAccNum+ "]";
	}

}

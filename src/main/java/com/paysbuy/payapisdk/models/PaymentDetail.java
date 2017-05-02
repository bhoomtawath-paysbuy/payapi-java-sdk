package com.paysbuy.payapisdk.models;

public class PaymentDetail {
	private String id;
	private String currency;
	private String status;
	private String redirect;
	private double amount;
	private double fees;
	private boolean captured;
	private boolean authorized;
	private boolean refunded;
	private boolean disputed;

	public void setId(String id) {
		this.id = id;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public void setCaptured(boolean captured) {
		this.captured = captured;
	}

	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

	public void setRefunded(boolean refunded) {
		this.refunded = refunded;
	}

	public void setDisputed(boolean disputed) {
		this.disputed = disputed;
	}

	public String getId() {
		return id;
	}

	public String getCurrency() {
		return currency;
	}

	public String getStatus() {
		return status;
	}

	public String getRedirect() {
		return redirect;
	}

	public double getAmount() {
		return amount;
	}

	public double getFees() {
		return fees;
	}

	public boolean isCaptured() {
		return captured;
	}

	public boolean isAuthorized() {
		return authorized;
	}

	public boolean isRefunded() {
		return refunded;
	}

	public boolean isDisputed() {
		return disputed;
	}
}

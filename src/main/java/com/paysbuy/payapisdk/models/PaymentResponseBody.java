package com.paysbuy.payapisdk.models;

public class PaymentResponseBody {
	private Payment payment;
	private Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}
}

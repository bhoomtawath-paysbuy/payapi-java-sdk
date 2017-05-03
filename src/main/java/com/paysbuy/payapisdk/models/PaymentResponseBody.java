package com.paysbuy.payapisdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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

	/**
	 * @return details of a payment
	 */
	public Payment getPayment() {
		return payment;
	}
}

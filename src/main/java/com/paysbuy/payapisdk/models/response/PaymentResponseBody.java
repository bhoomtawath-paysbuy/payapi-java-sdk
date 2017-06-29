package com.paysbuy.payapisdk.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paysbuy.payapisdk.models.Error;
import com.paysbuy.payapisdk.models.Payment;

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

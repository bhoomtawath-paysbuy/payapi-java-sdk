package com.paysbuy.payapisdk.models;

import okhttp3.Response;

public class PaymentResponse {
	private String id;
	private boolean success;
	private okhttp3.Response response;
	private PaymentResponseBody object;

	public void setId(String id) {
		this.id = id;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public void setObject(PaymentResponseBody object) {
		this.object = object;
	}

	public Response getResponse() {
		return response;
	}

	public PaymentResponseBody getObject() {
		return object;
	}

	public String getId() {
		return id;
	}

}

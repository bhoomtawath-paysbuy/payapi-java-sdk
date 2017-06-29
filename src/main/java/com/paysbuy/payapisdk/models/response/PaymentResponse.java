package com.paysbuy.payapisdk.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import okhttp3.Response;

@JsonIgnoreProperties(ignoreUnknown = true)
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

	public void setResponse(Response response) {
		this.response = response;
	}

	public void setObject(PaymentResponseBody object) {
		this.object = object;
	}

	/**
	 * @return status that indicate whether the operation is failed or succeeded
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @return original response including header and status code
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * @return a response that is converted into a POJO
	 */
	public PaymentResponseBody getObject() {
		return object;
	}

	public String getId() {
		return id;
	}

}

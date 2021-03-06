package com.paysbuy.payapisdk;

import com.fasterxml.jackson.core.JsonParseException;
import com.paysbuy.payapisdk.converters.JSONPaymentConverter;
import com.paysbuy.payapisdk.models.ChargeAttributes;
import com.paysbuy.payapisdk.models.response.PaymentResponse;
import okhttp3.Response;

import java.io.IOException;

public class PaymentService extends BaseService {

	public PaymentService(String secretAPIKey) {
		super(secretAPIKey, "payment");
	}

	public Response alive() throws IOException {
		return callService("GET", "alive", null);
	}

	/**
	 * Get payment using payment token
	 * @param paymentToken a token used to identify a payment
	 * @return Details of the payment
	 * @throws IOException
	 */
	public PaymentResponse getPayment(String paymentToken) throws IOException {
		return convertResult(callService(GET, paymentToken, prepareHeaders(encodedAPIKey).build()));
	}

	/**
	 * Charge a payment
	 * @param attributes	attributes of a payment
	 * @return	Details of the payment
	 * @throws IOException
	 */
	public PaymentResponse charge(ChargeAttributes attributes) throws IOException {
		return convertResult(callService(POST, "/", attributes.toJSON(), prepareHeaders(encodedAPIKey).build()));
	}

	/**
	 * Capture an authorized payment
	 * @param paymentToken a token used to identify a payment
	 * @return Details of the payment
	 * @throws IOException
	 */
	public PaymentResponse capture(String paymentToken) throws IOException {
		return convertResult(callService(POST, paymentToken + "/capture", null, prepareHeaders(encodedAPIKey).build()));
	}

	private PaymentResponse convertResult(Response response) throws IOException {
		JSONPaymentConverter converter = new JSONPaymentConverter();
		PaymentResponse paymentResponse;
		try {
			paymentResponse = converter.convert(response.body().string());
			paymentResponse.setResponse(response);
		} catch (JsonParseException e) {
			paymentResponse = new PaymentResponse();
			paymentResponse.setResponse(response);
		}

		return paymentResponse;
	}
}

package com.paysbuy.payapisdk;

import com.fasterxml.jackson.core.JsonParseException;
import com.paysbuy.payapisdk.converters.JSONPaymentConverter;
import com.paysbuy.payapisdk.models.ChargeAttributes;
import com.paysbuy.payapisdk.models.PaymentResponse;
import okhttp3.HttpUrl;
import okhttp3.Response;

import java.io.IOException;
import java.util.Base64;

public class PaymentService {
	private static final String SERVICE_NAME = "payment";

	private String encodedAPIKey;

	public PaymentService(String secretAPIKey) {
		encodedAPIKey = new String(Base64.getEncoder().encode((secretAPIKey + ":").getBytes()));
	}

	public Response alive() throws IOException {
		return ApiResource.request("GET", prepareUrl("alive"), null);
	}

	public PaymentResponse getPayment(String paymentToken) throws IOException {
		return convertResult(ApiResource.request("GET", prepareUrl(paymentToken), ApiResource.prepareDefaultHeaders(encodedAPIKey).build()));
	}

	public PaymentResponse charge(ChargeAttributes attributes) throws IOException {
		return convertResult(ApiResource.request("POST", prepareUrl("/"), attributes.toJSON(), ApiResource.prepareDefaultHeaders(encodedAPIKey).build()));
	}

	public PaymentResponse capture(String paymentToken) throws IOException {
		return convertResult(ApiResource.request("POST", prepareUrl(paymentToken + "/capture"), null, ApiResource.prepareDefaultHeaders(encodedAPIKey).build()));
	}

	private HttpUrl prepareUrl(String segments) {
		return ApiResource.prepareUrl()
				.addPathSegment(SERVICE_NAME)
				.addPathSegments(segments)
				.build();
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

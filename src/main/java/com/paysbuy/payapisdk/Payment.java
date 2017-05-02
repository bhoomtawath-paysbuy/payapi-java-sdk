package com.paysbuy.payapisdk;

import okhttp3.HttpUrl;
import okhttp3.Response;

import java.io.IOException;
import java.util.Base64;

public class Payment {
	private static final String SERVICE_NAME = "payment";

	private String encodedAPIKey;

	public Payment(String secretAPIKey) {
		encodedAPIKey = new String(Base64.getEncoder().encode((secretAPIKey + ":").getBytes()));
	}

	public Response alive() throws IOException {
		return ApiResource.request("GET", prepareUrl("alive"), null);
	}

	public Response getToken(String paymentToken) throws IOException {
		return ApiResource.request("GET", prepareUrl(paymentToken), ApiResource.prepareDefaultHeaders(encodedAPIKey).build());
	}

	public Response charge(ChargeAttributes attributes) throws IOException {
		return ApiResource.request("POST", prepareUrl("/"), attributes.toJSON(), ApiResource.prepareDefaultHeaders(encodedAPIKey).build());
	}

	public Response capture(String paymentToken) throws IOException {
		return ApiResource.request("POST", prepareUrl(paymentToken + "/capture"), null, ApiResource.prepareDefaultHeaders(encodedAPIKey).build());
	}

	private HttpUrl prepareUrl(String segments) {
		return ApiResource.prepareUrl()
				.addPathSegment(SERVICE_NAME)
				.addPathSegments(segments)
				.build();
	}
}

package com.paysbuy.payapisdk;

import okhttp3.HttpUrl;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Base64;

public class Payment {
	private static final String SERVICE_NAME = "payment";

	private String encodedAPIKey;

	public Payment(String secretAPIKey) {
		encodedAPIKey = new String(Base64.getEncoder().encode((secretAPIKey + ":").getBytes()));
	}

	public ResponseBody alive() throws IOException {
		return ApiResource.request("GET", prepareUrl("alive"), null);
	}

	public ResponseBody getToken(String paymentToken) throws IOException {
		return ApiResource.request("GET", prepareUrl(paymentToken), ApiResource.prepareDefaultHeaders(encodedAPIKey).build());
	}

	public ResponseBody charge(ChargeAttributes attributes) throws IOException {
		return ApiResource.request("POST", prepareUrl("/"), attributes.toJSON(), ApiResource.prepareDefaultHeaders(encodedAPIKey).build());
	}

	public ResponseBody capture(String paymentToken) throws IOException {
		return ApiResource.request("POST", prepareUrl(paymentToken + "/capture"), null, ApiResource.prepareDefaultHeaders(encodedAPIKey).build());
	}

	private HttpUrl prepareUrl(String segments) {
		return ApiResource.prepareUrl()
				.addPathSegment(SERVICE_NAME)
				.addPathSegments(segments)
				.port(2999)
				.build();
	}
}

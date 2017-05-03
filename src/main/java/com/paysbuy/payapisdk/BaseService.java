package com.paysbuy.payapisdk;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

class BaseService {

	static final String GET = "GET";
	static final String POST = "POST";
	static final String DELETE = "DELETE";
	static final String PUT = "PUT";
	static final String PATCH = "PATCH";


	protected String encodedAPIKey;
	private String serviceName;

	public BaseService(String secretAPIKey, String serviceName) {
		encodedAPIKey = new String(Base64.encodeBase64((secretAPIKey + ":").getBytes()));
		this.serviceName = serviceName;
	}

	protected HttpUrl prepareUrl(String segments) {
		return ApiResource.prepareUrl()
				.addPathSegment(serviceName)
				.addPathSegments(segments)
				.build();
	}

	protected Headers.Builder prepareHeaders(String encodedAPIKey) {
		return ApiResource.prepareDefaultHeaders(encodedAPIKey);
	}

	protected Response callService(String method, String segment, Headers headers) throws IOException {
		return ApiResource.request(method, prepareUrl(segment), headers);
	}

	protected Response callService(String method, String segment, String attributes, Headers headers) throws IOException {
		return ApiResource.request(method, prepareUrl(segment), attributes, headers);
	}
}

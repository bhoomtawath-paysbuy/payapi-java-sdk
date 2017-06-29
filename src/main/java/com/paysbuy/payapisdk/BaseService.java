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

	public BaseService(String secretAPIKey) {
		encodedAPIKey = encodeAPIKey(secretAPIKey);
	}

	public BaseService(String secretAPIKey, String serviceName) {
		encodedAPIKey = encodeAPIKey(secretAPIKey);
		this.serviceName = serviceName;
	}

	/**
	 * @param segments url segments that is separated by "/" ("/" at the beginning shouldn't exist)
	 * @return url of the request
	 */
	protected HttpUrl prepareUrl(String segments) {
		HttpUrl.Builder urlBuilder = ApiResource.prepareUrl();
		if (serviceName != null) {
			urlBuilder.addPathSegment(serviceName);
		}

		if (segments != null) {
			urlBuilder.addPathSegments(segments);
		}

		return urlBuilder.build();
	}

	/**
	 * Attach an encoded API key to the header
	 * @param encodedAPIKey
	 * @return
	 */
	protected Headers.Builder prepareHeaders(String encodedAPIKey) {
		return ApiResource.prepareDefaultHeaders(encodedAPIKey);
	}

	protected Response callService(String method, String segment, Headers headers) throws IOException {
		return ApiResource.request(method, prepareUrl(segment), headers);
	}

	protected Response callService(String method, String segment, String attributes, Headers headers) throws IOException {
		return ApiResource.request(method, prepareUrl(segment), attributes, headers);
	}

	private String encodeAPIKey(String secretAPIKey) {
		return new String(Base64.encodeBase64((secretAPIKey + ":").getBytes()));
	}
}

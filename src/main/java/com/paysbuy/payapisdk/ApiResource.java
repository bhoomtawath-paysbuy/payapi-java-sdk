package com.paysbuy.payapisdk;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;

import java.io.IOException;

class ApiResource {

	static Response request(String method, HttpUrl url, Headers headers) throws IOException {
		return HttpHelper.request(method, url, null, headers);
	}

	static Response request(String method, HttpUrl url, String payload, Headers headers) throws IOException {
		return HttpHelper.request(method, url, payload, headers);
	}

	/**
	 * @param encodedAPIKey
	 * @return a header with authorization and Content-Type
	 */
	static Headers.Builder prepareDefaultHeaders(String encodedAPIKey) {
		return new Headers.Builder()
				.add("authorization", "Basic " + encodedAPIKey)
				.add("Content-Type", "application/x-www-form-urlencoded");
	}

	/**
	 * @return HttpUrl with scheme and host
	 */
	static HttpUrl.Builder prepareUrl() {
		return new HttpUrl.Builder()
				.scheme(Config.HTTP_SCHEME)
				.host(Config.URL);
	}
}

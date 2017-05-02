package com.paysbuy.payapisdk;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;

import java.io.IOException;

class ApiResource {

	static ResponseBody request(String method, HttpUrl url, Headers headers) throws IOException {
		return HttpHelper.request(method, url, null, headers);
	}

	static ResponseBody request(String method, HttpUrl url, String payload, Headers headers) throws IOException {
		return HttpHelper.request(method, url, payload, headers);
	}

	static Headers.Builder prepareDefaultHeaders(String encodedAPIKey) {
		return new Headers.Builder()
				.add("authorization", "Basic " + encodedAPIKey)
				.add("Content-Type", "application/x-www-form-urlencoded");
	}

	static HttpUrl.Builder prepareUrl() {
		return new HttpUrl.Builder()
				.scheme(Config.HTTP_SCHEME)
				.host(Config.URL);
	}
}

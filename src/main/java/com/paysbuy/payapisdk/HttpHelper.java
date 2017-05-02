package com.paysbuy.payapisdk;

import okhttp3.*;

import java.io.IOException;

class HttpHelper {

	private static OkHttpClient client;

	private static final MediaType JSON = MediaType.parse("application/json");

	static Response request(String method, HttpUrl url, String payload, Headers headers) throws IOException {
		createClient();
		RequestBody body = null;
		if (payload != null) {
			body = RequestBody.create(JSON, payload);
		} else if (!method.equals("GET")) {
			body = RequestBody.create(null, new byte[0]);
		}

		Request req = buildRequest(url, headers)
				.method(method, body)
				.build();

		return client.newCall(req).execute();
	}

	private static Request.Builder buildRequest(HttpUrl url, Headers headers) {
		Request.Builder rb = new Request.Builder()
				.url(url);
		if (headers != null) {
			rb.headers(headers);
		}

		return rb;
	}

	static OkHttpClient createClient() {
		if (client == null) {
			client = new OkHttpClient();
		}

		return client;
	}
}

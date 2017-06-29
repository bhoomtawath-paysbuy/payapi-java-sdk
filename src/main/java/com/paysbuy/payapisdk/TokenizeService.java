package com.paysbuy.payapisdk;

import okhttp3.Response;

import java.io.IOException;

public class TokenizeService extends BaseService
{
	public TokenizeService(String publicKey) {
		super(publicKey);
	}

	public Response alive() throws IOException {
		return callService("GET", "alive", null);
	}
}

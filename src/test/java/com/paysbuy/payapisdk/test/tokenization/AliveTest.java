package com.paysbuy.payapisdk.test.tokenization;

import com.paysbuy.payapisdk.TokenizeService;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AliveTest {

	@Test
	public void healthCheckShouldRespondWithOK() {
		try {
			TokenizeService tokenizeService = new TokenizeService("");
			Response aliveResult = tokenizeService.alive();
			Assert.assertEquals(aliveResult.code(), 200);
			Assert.assertEquals(aliveResult.body().string(), "OK");
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}
}

package com.paysbuy.payapisdk.test.payment;

import com.paysbuy.payapisdk.PaymentService;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AliveTest {

	@Test
	public void healthCheckShouldRespondWithOK() {
		try {
			PaymentService paymentService = new PaymentService("");
			Response aliveResult = paymentService.alive();
			Assert.assertEquals(aliveResult.code(), 200);
			Assert.assertEquals(aliveResult.body().string(), "OK");
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}
}

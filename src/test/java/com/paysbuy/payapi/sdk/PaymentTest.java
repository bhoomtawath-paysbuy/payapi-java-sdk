package com.paysbuy.payapi.sdk;

import com.paysbuy.payapisdk.Payment;
import okhttp3.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class PaymentTest {

	@Test
	public void healthCheckShouldRespondWithOK() {
		try {
			Payment payment = new Payment("");
			ResponseBody aliveResult = payment.alive();
			Assert.assertEquals(aliveResult.string(), "OK");
		} catch (IOException e) {
			Assert.fail();
		}

	}
}

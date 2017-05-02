package com.paysbuy.payapi.sdk.payment;

import com.paysbuy.payapisdk.Payment;
import okhttp3.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AliveTest {

	@Test
	public void healthCheckShouldRespondWithOK() {
		try {
			Payment payment = new Payment("");
			ResponseBody aliveResult = payment.alive().body();
			Assert.assertEquals(aliveResult.string(), "OK");
		} catch (IOException e) {
			Assert.fail();
		}
	}
}

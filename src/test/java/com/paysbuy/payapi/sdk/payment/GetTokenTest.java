package com.paysbuy.payapi.sdk.payment;

import com.paysbuy.payapisdk.Payment;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GetTokenTest {
	@Test
	public void getTokenShouldRespondWithUnauthorizedIfWrongAPIKeyIsUsed() {
		try {
			Payment payment = new Payment("pub_unauthorized");
			Response rb = payment.getToken("pay_1234");
			Assert.assertEquals(rb.code(), 401);
		} catch (IOException e) {
			Assert.fail();
		}
	}
}

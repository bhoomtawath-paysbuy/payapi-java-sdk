package com.paysbuy.payapisdk.test.payment;

import com.paysbuy.payapisdk.PaymentService;
import com.paysbuy.payapisdk.models.response.PaymentResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CaptureTest {

	@Test
	public void captureShouldRespondWithUnauthorizedIfWrongAPIKeyIsUsed() {
		try {
			PaymentService paymentService = new PaymentService("pub_unauthorized");
			PaymentResponse pr = paymentService.capture(Config.PAYMENT_TOKEN);
			Assert.assertEquals(pr.getResponse().code(), 401);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void captureShouldRespondWithNotFoundIfPaymentTokenDoesNotExist() {
		try {
			PaymentService paymentService = new PaymentService(Config.API_KEY);
			PaymentResponse pr = paymentService.capture("pay_notfound");
			Assert.assertEquals(pr.getResponse().code(), 404);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void captureShouldRespondWithSuccessAsTrue() {
		try {
			PaymentService paymentService = new PaymentService(Config.API_KEY);
			PaymentResponse pr = paymentService.capture(Config.PAYMENT_TOKEN);
			Assert.assertEquals(pr.getResponse().code(), 200);
			Assert.assertEquals(pr.isSuccess(), true);
		} catch (IOException e) {
			Assert.fail();
		}
	}
}

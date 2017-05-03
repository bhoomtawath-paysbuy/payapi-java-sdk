package com.paysbuy.payapisdk.test.payment;

import com.paysbuy.payapisdk.PaymentService;
import com.paysbuy.payapisdk.models.PaymentResponse;
import com.paysbuy.payapisdk.models.PaymentResponseBody;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;

public class GetPaymentTest {
	@Test
	public void getTokenShouldRespondWithUnauthorizedIfWrongAPIKeyIsUsed() {
		try {
			PaymentService paymentService = new PaymentService("pub_unauthorized");
			PaymentResponse pr = paymentService.getPayment("pay_1234");
			Assert.assertEquals(pr.getResponse().code(), 401);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void getTokenShouldRespondWithNotFoundIfPaymentTokenDoesNotExist() {
		try {
			PaymentService paymentService = new PaymentService(Config.API_KEY);
			PaymentResponse pr = paymentService.getPayment("pay_1234");
			Assert.assertEquals(pr.getResponse().code(), 404);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void getTokenShouldReturnPaymentResponse() {
		try {
			PaymentService paymentService = new PaymentService(Config.API_KEY);
			PaymentResponse pr = paymentService.getPayment(Config.PAYMENT_TOKEN);
			Assert.assertEquals(pr.getResponse().code(), 200);
			Assert.assertThat(pr.getObject(), instanceOf(PaymentResponseBody.class));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}
}

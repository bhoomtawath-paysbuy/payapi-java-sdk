package com.paysbuy.payapisdk.test.payment;

import com.paysbuy.payapisdk.PaymentService;
import com.paysbuy.payapisdk.models.ChargeAttributes;
import com.paysbuy.payapisdk.models.PaymentResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ChargeTest {

	private ChargeAttributes chargeAttributes;

	@Before
	public void before() {
		chargeAttributes = new ChargeAttributes();
		chargeAttributes.setCurrency("THB");
		chargeAttributes.setAmount(100.5);
		chargeAttributes.setToken("tok_1234");
		chargeAttributes.setInvoice("Invoice");
	}

	@Test
	public void chargeShouldRespondWithUnauthorizedIfWrongAPIKeyIsUsed() {
		try {
			PaymentService paymentService = new PaymentService("pub_unauthorized");
			PaymentResponse pr = paymentService.charge(chargeAttributes);
			Assert.assertEquals(pr.getResponse().code(), 401);
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void chargeShouldRespondWithNotFoundIfPaymentTokenDoesNotExist() {
		try {
			ChargeAttributes invalidAttributes = new ChargeAttributes();
			PaymentService paymentService = new PaymentService(Config.API_KEY);
			PaymentResponse pr = paymentService.charge(invalidAttributes);
			Assert.assertEquals(pr.getResponse().code(), 400);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}
}

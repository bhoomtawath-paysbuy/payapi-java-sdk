package com.paysbuy.payapisdk.test.converters;

import com.paysbuy.payapisdk.converters.JSONPaymentConverter;
import com.paysbuy.payapisdk.models.*;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class JSONPaymentConverterTest {
	@Test
	public void itShouldConvertJSONStringToPaymentResponse() {
		try {
			JSONPaymentConverter converter = new JSONPaymentConverter();
			PaymentResponse pr = converter.convert(jSON);
			Assert.assertEquals(pr.getId(), "req_92b18e52c9afe7b8a403");
			Assert.assertEquals(pr.isSuccess(), true);
			Assert.assertThat(pr.getObject(), CoreMatchers.instanceOf(PaymentResponseBody.class));

			PaymentResponseBody body = pr.getObject();
			Assert.assertThat(body.getPayment(), CoreMatchers.instanceOf(Payment.class));
			Payment payment = body.getPayment();
			Assert.assertThat(payment.getSources().get(0), CoreMatchers.instanceOf(SourceOfFund.class));
			SourceOfFund srcOfFund = payment.getSources().get(0);
			Assert.assertThat(srcOfFund.getSources(), CoreMatchers.instanceOf(SourceOfFundInfo.class));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	private String jSON = "{\n" +
			"  \"id\": \"req_92b18e52c9afe7b8a403\",\n" +
			"  \"success\": true,\n" +
			"  \"object\": {\n" +
			"    \"payment\": {\n" +
			"      \"id\": \"pay_test_0a8700596e7e22f4aa16\",\n" +
			"      \"livemode\": false,\n" +
			"      \"location\": \"/payment/pay_test_0a8700596e7e22f4aa16\",\n" +
			"      \"sources\": [\n" +
			"        {\n" +
			"          \"id\": \"tok_1234\",\n" +
			"          \"source\": {\n" +
			"            \"id\": \"card_test_456\",\n" +
			"            \"type\": \"card\",\n" +
			"            \"livemode\": false,\n" +
			"            \"brand\": \"VISA\",\n" +
			"            \"bank\": null,\n" +
			"            \"country\": null,\n" +
			"            \"last_digits\": \"4567\",\n" +
			"            \"expiration_month\": 9,\n" +
			"            \"expiration_year\": 2020,\n" +
			"            \"cvc_checked\": \"true\",\n" +
			"            \"avs_checked\": \"true\",\n" +
			"            \"fingerprint\": \"123\",\n" +
			"            \"name\": \"far boo\",\n" +
			"            \"city\": \"Bangkok\",\n" +
			"            \"postal_code\": \"10100\",\n" +
			"            \"created\": \"2017-02-28T12:00:00+07\",\n" +
		"							 \"updatedBy\": \"Title\"\n" +
			"          }\n" +
			"        }\n" +
			"      ],\n" +
			"      \"details\": {\n" +
			"        \"tok_1234\": {\n" +
			"          \"id\": \"trans_118d57213bee976a5c96\",\n" +
			"          \"amount\": \"500.00\",\n" +
			"          \"fees\": \"20.00\",\n" +
			"          \"currency\": \"THB\",\n" +
			"          \"captured\": false,\n" +
			"          \"authorized\": false,\n" +
			"          \"refunded\": false,\n" +
			"          \"disputed\": false,\n" +
			"          \"status\": \"processing\",\n" +
			"          \"redirect\": \"http://dev.paysbuy.com/restapicc/CYBSProcessing?PaymentType=API&PaymentRefID=VSaKyjfcHtrDr-83ktQabw==\"\n" +
			"        }\n" +
			"      },\n" +
			"      \"invoice\": \"Invoice\",\n" +
			"      \"description\": \"Desc\",\n" +
			"      \"customer\": null,\n" +
			"      \"meta\": \"meta\",\n" +
			"      \"created\": \"2017-03-31T05:13:10+07\"\n" +
			"    }\n" +
			"  }\n" +
			"}";
}

package com.paysbuy.payapisdk.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.paysbuy.payapisdk.models.PaymentResponse;

import java.io.IOException;

public class JSONPaymentConverter {
	public PaymentResponse convert(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		return mapper.readValue(json, PaymentResponse.class);
	}
}

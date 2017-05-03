package com.paysbuy.payapisdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

	private String message;
	private String[] input;

	/**
	 * @return error message
	 */
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return fields that are invalid
	 */
	public String[] getInput() {
		return input;
	}

	public void setInput(String[] input) {
		this.input = input;
	}
}

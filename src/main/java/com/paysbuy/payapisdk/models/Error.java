package com.paysbuy.payapisdk.models;

public class Error {

	private String message;
	private String[] input;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getInput() {
		return input;
	}

	public void setInput(String[] input) {
		this.input = input;
	}
}

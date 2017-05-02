package com.paysbuy.payapisdk.models;

public class SourceOfFund {
	private String id;
	private SourceOfFundInfo source;

	public void setId(String id) {
		this.id = id;
}

	public String getId() {
		return id;
	}

	public SourceOfFundInfo getSources() {
		return source;
	}

	public void setSource(SourceOfFundInfo source) {
		this.source = source;
	}
}

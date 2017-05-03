package com.paysbuy.payapisdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment {
	private String id;
	private String location;
	private String invoice;
	private String description;
	private String customer;
	private String meta;
	private String created;
	private boolean livemode;
	private List<SourceOfFund> sources;
	private Map<String, PaymentDetail> details;

	public Map<String, PaymentDetail> getDetails() {
		return details;
	}

	public void setDetails(Map<String, PaymentDetail> details) {
		this.details = details;
	}

	public void setLivemode(boolean livemode) {
		this.livemode = livemode;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public void setSources(List<SourceOfFund> sources) {
		this.sources = sources;
	}

	/**
	 * @return a list of source of fund that are used to pay for the payment
	 */
	public List<SourceOfFund> getSources() {
		return sources;
	}

	public boolean isLivemode() {
		return livemode;
	}

	public String getId() {
		return id;
	}

	/**
	 * @return aroute to retrieve information of the payment
	 */
	public String getLocation() {
		return location;
	}

	public String getInvoice() {
		return invoice;
	}

	public String getDescription() {
		return description;
	}

	/**
	 * @return a token used to identify a customer
	 */
	public String getCustomer() {
		return customer;
	}

	public String getMeta() {
		return meta;
	}

	/**
	 * @return a date string that the payment is created
	 */
	public String getCreated() {
		return created;
	}

}

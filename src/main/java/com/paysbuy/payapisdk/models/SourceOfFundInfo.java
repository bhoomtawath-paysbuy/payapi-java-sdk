package com.paysbuy.payapisdk.models;

public class SourceOfFundInfo {

	private String id;
	private String type;
	private String brand;
	private String bank;
	private String country;
	private String lastDigits;
	private String cvcChecked;
	private String avsChecked;
	private String name;
	private String city;
	private String postalCode;
	private String created;
	private String fingerprint;
	private int expirationMonth;
	private int expirationYear;
	private boolean livemode;

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLastDigits(String lastDigits) {
		this.lastDigits = lastDigits;
	}

	public void setCvcChecked(String cvcChecked) {
		this.cvcChecked = cvcChecked;
	}

	public void setAvsChecked(String avsChecked) {
		this.avsChecked = avsChecked;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}

	public void setLivemode(boolean livemode) {
		this.livemode = livemode;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public int getExpirationMonth() {
		return expirationMonth;
	}

	public int getExpirationYear() {
		return expirationYear;
	}

	public boolean isLivemode() {
		return livemode;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	public String getBank() {
		return bank;
	}

	public String getCountry() {
		return country;
	}

	public String getLastDigits() {
		return lastDigits;
	}

	public String getCvcChecked() {
		return cvcChecked;
	}

	public String getAvsChecked() {
		return avsChecked;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCreated() {
		return created;
	}
}

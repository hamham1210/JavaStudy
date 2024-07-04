package com.edu.vo;

public class Address {
	private int zipCode;
	private String region;
	private String city;
	
	public Address() {}

	public Address(int zipCode, String region, String city) {
		this.zipCode = zipCode;
		this.region = region;
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String addresstoString() {
		return zipCode +","+region+","+city;
	}
	
	
}

package com.willy.lc.api;

public class Phone {

	private String countryCode;
	private String userNumber;
	private String userNumber2;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserNumber2() {
		return userNumber2;
	}

	public void setUserNumber2(String userNumber2) {
		this.userNumber2 = userNumber2;
	}

	@Override
	public String toString() {
		return countryCode + "-" + userNumber + "-" + userNumber2;
	}

	

}

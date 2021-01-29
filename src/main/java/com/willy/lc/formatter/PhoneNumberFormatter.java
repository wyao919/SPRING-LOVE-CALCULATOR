package com.willy.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import com.willy.lc.api.Phone;

public class PhoneNumberFormatter implements org.springframework.format.Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {

		System.out.println("inside the print method of the Formatter class");
		return phone.getCountryCode() + "-" + phone.getUserNumber() + "-" + phone.getUserNumber2();

	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {

		Phone phone = new Phone();
		String[] phoneNumberArray = completePhoneNumber.split("-");

	
		if (completePhoneNumber.indexOf('-') == -1) 
		{
			phone.setCountryCode("626");
			phone.setUserNumber(phoneNumberArray[0]);
		}
		else if (completePhoneNumber.indexOf('-') == 0) 
		{
			phone.setCountryCode("626");
			phone.setUserNumber(phoneNumberArray[1]);
		}
		else
		{
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
			phone.setUserNumber2(phoneNumberArray[2]);
		}
		System.out.println("in the formatter method");

		return phone;
	}

}

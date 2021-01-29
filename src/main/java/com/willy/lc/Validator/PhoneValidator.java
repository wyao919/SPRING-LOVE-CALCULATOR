package com.willy.lc.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.willy.lc.api.Phone;

public class PhoneValidator implements ConstraintValidator<PhoneV, Phone> {

	private String message;

	@Override
	public void initialize(PhoneV constraintAnnotation) {

		System.out.println("initialize phone validator");
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Phone phoneNumber, ConstraintValidatorContext context) {

		System.out.println("check valid phone");
		System.out.println("phone # is" + phoneNumber);

		if (phoneNumber == null) {
			System.out.println("cannot be null");
			return false;
		}
		if (!phoneNumber.getCountryCode().matches("[0123456789]+")) {
			System.out.println("only numbers");
			return false;
		}
		if (!phoneNumber.getUserNumber().matches("[0123456789]+")) {
			System.out.println("only numbers");
			return false;
		}
		if (!phoneNumber.getUserNumber2().matches("[0123456789]+"))

		{
			System.out.println("only numbers");
			return false;
		}

		System.out.println("phone number returning true");

		return true;
	}

}

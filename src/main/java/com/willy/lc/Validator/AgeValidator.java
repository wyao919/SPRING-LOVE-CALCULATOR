package com.willy.lc.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> { //first one is the annotation, second one is the type of field its going over

	private int lower; // 30  //th
	private int upper; // 70
	private String message;

	@Override
	public void initialize(Age age) {
		//write post 
		// initialize and set variables
		//this is where we set our own upper and lower
		System.out.println("initialize age validator");
		this.lower = age.lower();
		this.upper = age.upper();
		this.message = age.message();
	}

	@Override // write logic here
	public boolean isValid(Integer age, ConstraintValidatorContext context) { //the integer here is what the user inputs

		System.out.println("check valid age");
		if (age == null) {
			return false;
		}

		if (age < lower || age > upper) {
			return false; // fail
		}

		return true; // true means pass

	}

}

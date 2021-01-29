package com.willy.lc.Validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

	String message() default "{invalidAgeMessage}"; // this would be the default message
	int lower() default 18; // default lowest age
	int upper() default 60; // default highest age

	Class<?>[] groups() default {}; // this is a must have

	Class<? extends Payload>[] payload() default {}; // this is a must have

}

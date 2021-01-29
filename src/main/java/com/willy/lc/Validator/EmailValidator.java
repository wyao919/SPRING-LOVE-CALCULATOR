package com.willy.lc.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.willy.lc.api.RegisterDTO;

@Component
public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return RegisterDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.Empty");
	
		String email = ((RegisterDTO)object).getCommunicationDTO().getEmail().toLowerCase();
		if(!email.endsWith("seleniumexpress.com"))
		{
			errors.rejectValue("communicationDTO.email", "email.invalidDommain");
		}
	}

}

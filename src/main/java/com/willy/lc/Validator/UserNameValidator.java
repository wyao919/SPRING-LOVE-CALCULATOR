package com.willy.lc.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.willy.lc.api.RegisterDTO;
import com.willy.lc.api.UserInfoDTO;

public class UserNameValidator implements Validator{

	//check if the UserNameValidator supports a given object
	@Override
	public boolean supports(Class<?> clazz) {
		
		//Which DTO will you be using it?
		return RegisterDTO.class.equals(clazz);
	}

	//we need to write our custom validation logic
	@Override
	public void validate(Object object, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.Empty", "UserName cannot be empty");
		
		String userName = ((RegisterDTO)object).getUserName();
		
		if(!userName.contains("_"))
		{
			errors.rejectValue("userName", "userName.InvaliDString", "String should contain a _");
		}
		
	}

}

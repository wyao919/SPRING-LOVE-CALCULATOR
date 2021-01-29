package com.willy.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.willy.lc.Validator.EmailValidator;
import com.willy.lc.Validator.UserNameValidator;
import com.willy.lc.api.RegisterDTO;
import com.willy.lc.propertyeditor.NamePropertyEditor;

@Controller
public class RegistrationController {

	@Autowired
	private EmailValidator emailValidator;

	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("registerDTO") RegisterDTO registerDTO) {
		System.out.println("inside showRegistration page method");

//		Phone phone = new Phone();

//		CommunicationDTO communicationDTO = new CommunicationDTO();
//		communicationDTO.setPhone(phone);
//		
//		registerDTO.setCommunicationDTO(communicationDTO);

		return "registration-page";
	}

	@RequestMapping("/register-success")
	public String registrationSucess(@Valid @ModelAttribute("registerDTO") RegisterDTO dto, BindingResult result) {

//		  This is how you call the validator without the init binder
//		You can also do it by making the EmailValidator class a component and using @autowire
//		  EmailValidator validator = new EmailValidator(); 
//		  validator.validate(dto, result);

		emailValidator.validate(dto, result);

		System.out.println("Name value is: " + dto.getName() + " |");

		if (result.hasErrors()) {
			System.out.println("registeration page has errors");
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError error : allErrors) {
				System.out.println(error);
			}
			return "registration-page";
		}

		System.out.println("inside process registeration @controller");

		// save the dto object into the database

		return "registration-success";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("inside the init binder method");

		// This allows non binding for the field anme
//		binder.setDisallowedFields("name");

//		this class can trim the string if it contains white spaces
//		This can be used for @NotEmpty when people trick program with white spaces
//		Converts white space to null when editor is set to true
//		Trims white spaces to empty if it is set to false
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", editor);

		NamePropertyEditor nameEditor = new NamePropertyEditor();
//		binder.registerCustomEditor(String.class, nameEditor);
		binder.registerCustomEditor(String.class, "userName", nameEditor);

//		UserNameValidator validator = new UserNameValidator();
		binder.addValidators(new UserNameValidator());
//		binder.addValidators(new EmailValidator());

	}

}

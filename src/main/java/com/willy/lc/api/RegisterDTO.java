package com.willy.lc.api;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.willy.lc.Validator.Age;

public class RegisterDTO {
	
	private String userName;
	@NotEmpty(message = "{string.notEmpty}")
	private String name;
	private char [] password;
	private String countryName;
	private String[] hobbies;
	private String gender;
	@Age(lower = 45, upper = 50)
	private Integer age;
	@Valid private CommunicationDTO communicationDTO;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}
	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public char [] getPassword() {
		return password;
	}
	public void setPassword(char [] password) {
		this.password = password;
	}
	
	

}

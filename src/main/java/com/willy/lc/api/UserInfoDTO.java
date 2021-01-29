package com.willy.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {

	@NotBlank(message = "*User Name cannot be blank")
	@Size(min =3, max = 15, message ="*Name needs at least 3 characters")
	private String userName;	
	
	@NotBlank(message = "*crush Name cannot be blank")
	@Size(min =3, max = 15, message ="{userName.Size}")
	private String crushName;
	
	@AssertTrue(message ="*You must agree to use our terms and conditions")
	private boolean termAndCondition;
	
	public UserInfoDTO()
	{
		System.out.println("userInfoDTO Called");
	}
	
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getCrushName() 
	{
		return crushName;
	}
	public void setCrushName(String crushName) 
	{
		this.crushName = crushName;
	}

	public boolean isTermAndCondition() {
		return termAndCondition;
	}

	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
}

package com.willy.lc.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FeedBackDTO {

	@NotBlank(message = "Email can't be blank")
	private String userEmail;
	@NotBlank(message = "Name can't be blank")
	private String userName;
	@Size(min=10, max = 50, message = "Feedback needs to be between 10 - 50")
	private String feedBack;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

}

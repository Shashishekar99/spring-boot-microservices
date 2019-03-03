package com.utilities;

import javax.validation.constraints.NotBlank;

public class IsValidUser {
	
	@NotBlank(message="key should not be empty")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

}

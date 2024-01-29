package com.example.user.api.dto;

import lombok.Getter;

@Getter
public class ErrorWrapper {
	
	private final int errorStatus;
	
	private final String errorMessage;

	public ErrorWrapper(int errorStatus, String errorMessage) {
		super();
		this.errorStatus = errorStatus;
		this.errorMessage = errorMessage;
	}
}

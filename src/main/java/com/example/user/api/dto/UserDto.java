package com.example.user.api.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {
	
	private String id;

	@NotBlank(message =  "firstName is required")
	private String firstName;
	
	@NotBlank(message =  "lastName is required")
	private String lastName;

}

package com.example.user.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.api.dto.GenericResponse;
import com.example.user.api.dto.GenericResponseWithoutBody;
import com.example.user.api.dto.PaginatedResponse;
import com.example.user.api.dto.UserDto;
import com.example.user.api.endpoint.UserEndpoint;
import com.example.user.api.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController implements UserEndpoint{
	
	private final UserService userService; 

	@Override
	public ResponseEntity<GenericResponse> createUser( UserDto userDto) {
		var genericResponse = new GenericResponse(HttpStatus.OK.value(), "user created successfully.", userService.createOrUpdateUser(userDto, null));
		return ResponseEntity.ok(genericResponse);
	}

	@Override
	public ResponseEntity<GenericResponse> updateUser(UserDto userDto, String id) {
		var genericResponse = new GenericResponse(HttpStatus.OK.value(), "user updated successfully.", userService.createOrUpdateUser(userDto, id));
		return ResponseEntity.ok(genericResponse);
	}

	@Override
	public ResponseEntity<GenericResponse> getUserById(String id) {
		var genericResponse = new GenericResponse(HttpStatus.OK.value(), "user retrieved successfully.", userService.getUserById(id));
		return ResponseEntity.ok(genericResponse);
	}

	@Override
	public ResponseEntity<GenericResponseWithoutBody> deleteUserById(String id) {
		userService.deleteUserById(id);
		var genericResponse = new GenericResponseWithoutBody(HttpStatus.OK.value(), "user deleted successfully.");
		return ResponseEntity.ok(genericResponse);
	}

	@Override
	public ResponseEntity<GenericResponse> getPaginatedUsers(int pageNumber, int pageSize, String firstName, String lastName) {
		
		PaginatedResponse<List<UserDto>> paginatedUser = userService.getPaginatedUserd(pageNumber, pageSize, firstName, lastName);
		
		var genericResponse = new GenericResponse(HttpStatus.OK.value(), "users retrieved successfully.",paginatedUser);
		return ResponseEntity.ok(genericResponse);
	}

}

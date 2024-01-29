package com.example.user.api.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.user.api.dto.GenericResponse;
import com.example.user.api.dto.GenericResponseWithoutBody;
import com.example.user.api.dto.UserDto;

import jakarta.validation.constraints.NotNull;

@RequestMapping("/api/v1/users")
public interface UserEndpoint {

	@PostMapping
	public ResponseEntity<GenericResponse> createUser(@Validated @RequestBody @NotNull(message =  "request body is required. ") UserDto userDto);

	@PutMapping("/{id}")
	public ResponseEntity<GenericResponse> updateUser(@Validated @RequestBody @NotNull(message =  "request body is required. ") UserDto userDto,
			@PathVariable("id") String id);

	@GetMapping("/{id}")
	public ResponseEntity<GenericResponse> getUserById(@PathVariable("id") String id);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<GenericResponseWithoutBody> deleteUserById(@PathVariable("id") String id);
	
	@GetMapping
	public ResponseEntity<GenericResponse> getPaginatedUsers(@RequestParam("pageNumber") int pageNumber,
			@RequestParam("pageSize") int pageSize, @RequestParam(value = "firstName", required=false) String firstName,
			@RequestParam(value = "lastName", required=false) String lastName);

}

package com.example.user.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.user.api.dto.GenericResponse;
import com.example.user.api.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.TypeReference;

public class UserControllerTest extends ApplicationTest {

	private final String PRE_PATH = "/api/v1";
	private final String USERS_PATH = "/users";

//	@Test
//	public void testAddUser() throws JsonMappingException, JsonProcessingException {
//		UserDto userDto = new UserDto();
//		userDto.setFirstName("Ketan");
//		userDto.setLastName("Makwana");
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<UserDto> entity = new HttpEntity<>(userDto,headers);
//
//		StringBuilder path = new StringBuilder();
//		path.append(PRE_PATH).append(USERS_PATH);
//
//		ResponseEntity<String> response = this.testRestTemplate.exchange(path.toString(),  HttpMethod.POST, entity,
//				String.class);
//
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//
////		ObjectMapper mapper = new ObjectMapper();
////		GenericResponse<UserDto> genericResponse = mapper.readValue(response.getBody(), new TypeReference<GenericResponse<UserDto>>() {});
//
////		System.err.println(genericResponse.data());
//
//	}

	//	@Test
	//	public void testAddUserWithoutRequestBody() {
	//		
	//		HttpHeaders headers = new HttpHeaders();
	//		headers.setContentType(MediaType.APPLICATION_JSON);
	//		HttpEntity<UserDto> entity = new HttpEntity<>(null, headers);
	//
	//		StringBuilder path = new StringBuilder();
	//		path.append(PRE_PATH).append(USERS_PATH);
	//
	//		ResponseEntity<String> response = this.testRestTemplate.exchange(path.toString(),  HttpMethod.POST, entity,
	//				String.class);
	//		
	//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	//	}
}

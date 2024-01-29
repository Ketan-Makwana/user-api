package com.example.user.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.user.api.dto.PaginatedResponse;
import com.example.user.api.dto.UserDto;
import com.example.user.api.entity.User;
import com.example.user.api.mapper.UserMapper;
import com.example.user.api.repository.UserRepository;
import com.example.user.api.repository.specification.UserSpecification;
import com.example.user.api.utils.CommonUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;

	private final UserRepository userRepository;

	private final CommonUtils commonUtils;
	
	private final UserSpecification userSpecification;

	//	public UserDto createUser(UserDto userDto) {
	//		return userMapper.toUserDto(userRepository.save(userMapper.toUser(userDto)));
	//	}
	//
	//	public UserDto updateUser(UserDto userDto, String id) {
	//		return userMapper.toUserDto(userRepository.save(userMapper.toUser(userDto)));
	//	}

	public User findById(String id) {
		return userRepository.findById(id).orElseThrow(() -> {
			throw new RuntimeException("User with user id "+id+" not found");
		});
	}

	public UserDto getUserById(String id) {
		var exisintUser = findById(id);
		return userMapper.userToUserDto(exisintUser);
	}

	public UserDto createOrUpdateUser(UserDto userDto, String id) {
		User saveOrUpdateUser = null;

		if(StringUtils.isNotBlank(id)) {
			saveOrUpdateUser = findById(id);	
		} else {
			saveOrUpdateUser = new User();
		}

		userRepository.save(userMapper.userDtoToUser(saveOrUpdateUser, userDto));

		return getUserById(saveOrUpdateUser.getId());
	}

	public PaginatedResponse<List<UserDto>> getPaginatedUserd(int pageNumber, int pageSize, String firstName, String lastName) {
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
		Specification<User> specification = userSpecification.createUserSpecification(firstName, lastName);
		
		Page<User> existingUserPage = userRepository.findAll(specification, pageable);

		List<UserDto> userDtoList = new ArrayList<>();

		if (CollectionUtils.isNotEmpty(existingUserPage.getContent())) {
			userDtoList = userMapper.userListToUserDtoList(existingUserPage.getContent());
		}
		return commonUtils.calculatePaginationAndPrepareResponse(existingUserPage, userDtoList);
	}

	public void deleteUserById(String id) {
		var exisintUser = findById(id);
		
	}
}

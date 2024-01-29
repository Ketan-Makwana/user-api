package com.example.user.api.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.example.user.api.dto.UserDto;
import com.example.user.api.entity.User;

@Mapper(
		componentModel = SPRING,
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		builder = @Builder(disableBuilder = true),
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface UserMapper {

	@Mapping(target = "id", ignore = true)
	public User userDtoToUser(@MappingTarget User user, UserDto userDto);

	public UserDto userToUserDto(User user);
	
	public List<UserDto> userListToUserDtoList(List<User> userList);
}

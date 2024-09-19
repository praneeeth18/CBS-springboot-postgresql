package com.praneeth.cbs.mapper;

import org.springframework.stereotype.Service;

import com.praneeth.cbs.dto.UserRequestDTO;
import com.praneeth.cbs.dto.UserResponseDTO;
import com.praneeth.cbs.model.User;

@Service
public class UserMapper {
	
	public User toUser(UserRequestDTO user) {
		return User.builder()
				.firstName(user.firstName())
				.lastName(user.lastName())
				.email(user.email())
				.password(user.password())
				.build();
	}
	
	public UserResponseDTO toUserDTO(User user) {
		return new UserResponseDTO(
				user.getUserId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
				);
	}

}

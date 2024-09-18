package com.praneeth.cbs.service;

import java.util.List;

import com.praneeth.cbs.dto.UserRequestDTO;
import com.praneeth.cbs.dto.UserResponseDTO;

public interface UserService {

	public UserResponseDTO createUser(UserRequestDTO request);
	public List<UserResponseDTO> findAllUsers();
	public List<UserResponseDTO> findByUserId(Integer userId);
	public UserResponseDTO updateUser(Integer userId, UserRequestDTO request);
	public String deleteUser(Integer userId);

}

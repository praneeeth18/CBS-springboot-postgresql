package com.praneeth.cbs.service;

import java.util.List;

import com.praneeth.cbs.dto.UserRequestDTO;
import com.praneeth.cbs.dto.UserResponseDTO;
import com.praneeth.cbs.exception.ResourceNotFoundException;
import com.praneeth.cbs.exception.UserAlreadyExistsException;

public interface UserService {

	public UserResponseDTO createUser(UserRequestDTO request) throws UserAlreadyExistsException;
	public List<UserResponseDTO> findAllUsers();
	public UserResponseDTO findByEmail(String email) throws ResourceNotFoundException;
	public UserResponseDTO updateUser(Integer userId, UserRequestDTO request);
	public String deleteUser(Integer userId);

}

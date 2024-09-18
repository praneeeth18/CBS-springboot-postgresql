package com.praneeth.cbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.praneeth.cbs.dto.UserRequestDTO;
import com.praneeth.cbs.dto.UserResponseDTO;
import com.praneeth.cbs.mapper.UserMapper;
import com.praneeth.cbs.model.User;
import com.praneeth.cbs.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	@Override
	public UserResponseDTO createUser(UserRequestDTO request) {
		User user = userRepository.save(userMapper.toUser(request));
		return userMapper.toUserDTO(user);
	}

	@Override
	public List<UserResponseDTO> findAllUsers() {
		return userRepository.findAll()
				.stream()
				.map(userMapper::toUserDTO)
				.toList();
	}

	@Override
	public List<UserResponseDTO> findByUserId(Integer userId) {
		return userRepository.findById(userId)
				.stream()
				.map(userMapper::toUserDTO)
				.toList();
	}

	@Override
	public UserResponseDTO updateUser(Integer userId, UserRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.praneeth.cbs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praneeth.cbs.dto.UserRequestDTO;
import com.praneeth.cbs.dto.UserResponseDTO;
import com.praneeth.cbs.exception.ResourceNotFoundException;
import com.praneeth.cbs.exception.UserAlreadyExistsException;
import com.praneeth.cbs.service.UserServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
	
	private final UserServiceImpl userService;
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request) throws UserAlreadyExistsException {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userService.createUser(request));
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<UserResponseDTO> findByUserEmail(@PathVariable String email) throws ResourceNotFoundException {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.findByEmail(email));
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> findAllUsers() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.findAllUsers());
	}
}

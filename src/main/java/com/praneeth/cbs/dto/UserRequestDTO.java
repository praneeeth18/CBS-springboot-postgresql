package com.praneeth.cbs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
		
		@NotBlank(message = "Firstname is required")
		@Size(min = 2, max = 50, message = "Firstname must be between 2 and 50 characters")
		String firstName,
		
		@NotBlank(message = "Lastname is required")
		@Size(min = 2, max = 50, message = "Firstname must be between 2 and 50 characters")
		String lastName,
		
		@NotBlank(message = "Email is required")
		@Email(message = "Enter valid Email")
		String email,
		
		@NotBlank
		@Size(min = 8, message = "Password must be 8 characters")
		@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "Password must contain at least one letter and one number")
		String password
		
		) {}

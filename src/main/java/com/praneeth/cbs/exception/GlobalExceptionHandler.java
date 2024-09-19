package com.praneeth.cbs.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.praneeth.cbs.dto.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
		ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(webRequest.getDescription(false), HttpStatus.NOT_FOUND, exception.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorResponseDTO>(errorResponseDto, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,WebRequest webRequest) {
	    Map<String, String> validationErrors=new HashMap<>();
	    List<ObjectError> validationErrorList=	exception.getBindingResult().getAllErrors();
		    	validationErrorList.forEach(error -> {
		    	String fieldName =	((FieldError)error).getField();
		    	String validationMsg = error.getDefaultMessage();
		    	validationErrors.put(fieldName, validationMsg);
		    }
		);
	    return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDTO> handleUserAlreadyExistsException(UserAlreadyExistsException exception, WebRequest webRequest) {
		ErrorResponseDTO errorResponseDto = new ErrorResponseDTO(webRequest.getDescription(false), HttpStatus.CONFLICT, exception.getMessage(), LocalDateTime.now());
		return new ResponseEntity<>(errorResponseDto, HttpStatus.CONFLICT);
	}
}

package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.payload.ApiResponse;

import lombok.Builder;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourcesNotFoundException ex){
		String message = ex.getMessage();
//		ApiResponse apiResponse = new ApiResponse();
//		apiResponse.setMessage(message);
//		apiResponse.setStatus(HttpStatus.NOT_FOUND);
//		apiResponse.setSuccess(true);
		
		ApiResponse response =  ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
		
		
	}

}

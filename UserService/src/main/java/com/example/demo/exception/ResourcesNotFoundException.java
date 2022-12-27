package com.example.demo.exception;

public class ResourcesNotFoundException extends RuntimeException{
	
	public ResourcesNotFoundException() {
		super("Resource not found in server !!");
	}
	
	public ResourcesNotFoundException(String message) {
		super(message);
	}

}

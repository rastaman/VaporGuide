package com.bsalm.vaporguide.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String message) 
	{
		super(message);
	}
}

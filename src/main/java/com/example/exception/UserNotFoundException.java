package com.example.exception;

/**
 * @author shivam.rai
 *
 */
public class UserNotFoundException extends Exception {

	public UserNotFoundException(String message){
		super(message);
	}

}

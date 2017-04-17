package com.hellospring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
//@Repository
public class HelloWorld {
	
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void printMessage() {
		System.out.println("The message is " + getMessage());
	}

}

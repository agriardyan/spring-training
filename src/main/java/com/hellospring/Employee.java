package com.hellospring;

import java.util.ArrayList;
import java.util.List;



public class Employee {
	
	private String name;
	private String gender;
	
	/**
	 * @param name
	 * @param gender
	 */
	public Employee(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}

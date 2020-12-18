package com.example.wsb.domain;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

	private List<String> classes = new ArrayList<>();

	public Teacher(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public void addClass(String className) {
		classes.add(className);
	}

	public List<String> getClasses() {
		return classes;
	}

}

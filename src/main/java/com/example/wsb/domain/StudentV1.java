package com.example.wsb.domain;

import java.util.ArrayList;
import java.util.List;

public class StudentV1 {

	public String firstName;
	public String lastName;

	public List<Double> grades = new ArrayList<>();

	public StudentV1(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void addGrade(double grade) {
		grades.add(grade);
	}

	public double getAvgGrade() {
		if (grades.isEmpty()) {
			return 0;
		}

		double sum = 0;
		for (Double grade : grades) {
			sum += grade;
		}

		return sum / grades.size();
	}

}

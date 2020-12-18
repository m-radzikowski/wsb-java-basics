package com.example.wsb.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentV2 {

	public String firstName;
	public String lastName;

	/**
	 * Map of course names to grades.
	 */
	public Map<String, List<Double>> grades = new HashMap<>();

	public StudentV2(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void addGrade(String course, double grade) {
		grades.putIfAbsent(course, new ArrayList<>());
		grades.get(course).add(grade);
	}

	public double getAvgGrade(String course) {
		if (!grades.containsKey(course)) {
			return 0;
		}

		List<Double> courseGrades = grades.get(course);
		if (courseGrades.isEmpty()) {
			return 0;
		}

		double sum = 0;
		for (Double grade : courseGrades) {
			sum += grade;
		}
		return sum / courseGrades.size();
	}

}

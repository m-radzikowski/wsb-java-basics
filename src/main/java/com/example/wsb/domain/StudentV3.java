package com.example.wsb.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentV3 extends Person {

	/**
	 * Map of course names to grades.
	 */
	private Map<String, List<Double>> grades = new HashMap<>();

	public StudentV3(String firstName, String lastName) {
		super(firstName, lastName);
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

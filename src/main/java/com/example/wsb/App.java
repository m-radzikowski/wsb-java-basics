package com.example.wsb;

import com.example.wsb.domain.StudentV1;
import com.example.wsb.domain.StudentV2;
import com.example.wsb.domain.StudentV3;
import com.example.wsb.domain.Teacher;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello WSB");
		System.out.println();

		StudentV1 s1 = new StudentV1("John", "Doe");
		String s1Name = s1.getFullName();
		System.out.println("Student: " + s1Name);

		s1.addGrade(4);
		s1.addGrade(5);
		System.out.println("Średnia ocena: " + s1.getAvgGrade());
		System.out.println();

		StudentV2 s2 = new StudentV2("Jane", "Doe");
		String s2Name = s2.getFullName();
		System.out.println("Student: " + s2Name);

		s2.addGrade("python", 5);
		s2.addGrade("python", 3);
		s2.addGrade("r", 4);
		s2.addGrade("java", 4);
		s2.addGrade("java", 5);
		System.out.println("Średnia ocena z przedmiotu python: " + s2.getAvgGrade("python"));
		System.out.println();

		StudentV3 s3 = new StudentV3("Jan", "Kowalski");
		System.out.println("Student: " + s3.getFullName());
		s3.addGrade("java", 4);
		s3.addGrade("java", 4);
		s3.addGrade("java", 5);
		System.out.println("Średnia ocena z przedmiotu java: " + s3.getAvgGrade("java"));

		Teacher t = new Teacher("Anna", "Nowak");
		System.out.println("Nauczyciel: " + t.getFullName());
		t.addClass("java");
		t.addClass("python");
		System.out.println("Przedmioty: " + t.getClasses());
		System.out.println();

		Path path = Paths.get("students.csv");

		try {
			List<String> lines = Files.readAllLines(path);
			System.out.println("Odczyt z pliku " + path);
			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Nie udało się odczytać pliku. Błąd: " + e);
		}
		System.out.println();

		CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader();
		try {
			CSVParser parser = CSVParser.parse(path, Charset.defaultCharset(), csvFormat);
			List<CSVRecord> records = parser.getRecords();

			List<StudentV3> students = new ArrayList<>();
			for (CSVRecord record : records) {
				String firstName = record.get("firstName");
				String lastName = record.get("lastName");
				StudentV3 student = new StudentV3(firstName, lastName);
				students.add(student);
			}

			System.out.println("Studenci:");
			for (StudentV3 student : students) {
				System.out.println(student.getFullName());
			}
		} catch (IOException e) {
			System.out.println("Nie udało się wczytać danych. Błąd: " + e);
		}
	}
}

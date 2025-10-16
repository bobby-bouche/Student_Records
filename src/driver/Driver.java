package driver;

import java.util.ArrayList;

import data_classes.Student;
import io.FileHandler;

public class Driver {
	
	
	public static void main(String[] args) {
		
		Student student = new Student(1030, "billy", "computer_science", 3.7);
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(student);
		
		FileHandler.saveRecords("students.txt", students);
		
		System.out.println("students.txt");
		
	}

}

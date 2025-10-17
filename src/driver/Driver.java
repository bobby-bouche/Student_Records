package driver;

import java.util.ArrayList;

import data_classes.Student;
import io.FileHandler;

public class Driver {
	
	
	public static void main(String[] args) {
		
		Student student = new Student(1030, "billy", "computer science", 3.7);
		
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Student> data = new ArrayList<>();
		students.add(student);
		
		//FileHandler.saveRecords("students.txt", students);  // save records works
		
		//System.out.println("students.txt");
		
		data = FileHandler.loadRecords("students.txt");  // she lives!!
		
		for(Student s : data) {
			System.out.println(s.toString());
		}
		
	}

}

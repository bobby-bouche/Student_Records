package management;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data_classes.Student;
import io.FileHandler;

public class RecordManager {
	
	// fields
	private static Map<Integer, Student> students;
	
	
	
	// constructor
	public RecordManager() {
		super();
		students = new HashMap<>();
	}



	// getter method 
	public static Map<Integer, Student> getStudents() {
		return students;
	}

	
	
	// method to add student to students
	public void addStudent(Student student) {
		if(students.containsKey(student.getId())) {
			System.out.println("Sorry, this id already exists in system");
		}
		else {
			students.put(student.getId(), student);
		}
	}
	
	
	
	// method to remove student from students
	public void removeStudent(int id) {
		if(students.containsKey(id)) {
			students.remove(id);
		}
		else {
			System.out.println("Sorry, this id does not exist in system");
		}
	}
	
	
	
	// method to print out a list of students
	public void listAllStudents() {
		for(Student student : students.values()) {
			System.out.println(student.toString());
		}
	}
	
	
	public ArrayList<Student> studentsMapToList() {
		ArrayList<Student> studentList = new ArrayList<>();
		for(Student student : students.values()) {
			studentList.add(student);
		}
		return studentList;
	}
	
	
	
	
	public void saveAll(String fileName) {
		FileHandler.saveRecords(fileName, studentsMapToList());
	}
	
	
	
	
	public void loadAll(String fileName) {
		FileHandler.loadRecords(fileName);
	}
	
	
	
	
}

package management;


import java.util.HashMap;
import java.util.Map;

import data_classes.Student;

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

	
	
	
	public void addStudent(Student student) {}
	
	
	
	public void removeStudent(int id) {}
	
	
	
	public void listAllStudents() {}
	
	
	
	public void saveAll() {}
	
	
	
	public void loadAll() {}
	
	
	
	
}

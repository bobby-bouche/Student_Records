package management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data_classes.Student;
import exceptions.FileOperationException;
import io.FileHandler;

public class RecordManager {
	
	// fields
	private static Map<Integer, Student> student_Map;
	
	
	
	// constructor
	public RecordManager() {
		super();
		student_Map = new HashMap<>();
	}



	// getter method 
	public static Map<Integer, Student> getStudents() {
		return student_Map;
	}

	
	
	// method to add student to students
	public void addStudent(Student student) {
		if(student_Map.containsKey(student.getId())) {
			System.out.println("Sorry, this id already exists in system");
		}
		else {
			student_Map.put(student.getId(), student);
		}
	}
	
	
	
	// method to remove student from students
	public void removeStudent(int id) {
		if(student_Map.containsKey(id)) {
			student_Map.remove(id);
		}
		else {
			System.out.println("Sorry, this id does not exist in system");
		}
	}
	
	
	
	// method to print out a list of students
	public void listAllStudents() {
		for(Student student : student_Map.values()) {
			System.out.println(student.toString());
		}
	}
	
	
	public ArrayList<Student> studentsMapToList() {
		ArrayList<Student> studentList = new ArrayList<>();
		for(Student student : student_Map.values()) {
			studentList.add(student);
		}
		return studentList;
	}
	
	
	
	
	public void saveAll(String fileName) {
		FileHandler.saveRecords(fileName, studentsMapToList());
	}
	
	
	
	
	public void loadAll(String fileName) {
		try {
			ArrayList<Student> studentList = new ArrayList<>();
			studentList = FileHandler.loadRecords(fileName);
			for(Student student : studentList) {
				student_Map.put(student.getId(), student);
			}
		}
		catch(FileOperationException e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	
	
}

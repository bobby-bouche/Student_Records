package driver;

import data_classes.Student;
import exceptions.FileOperationException;
import io.FileHandler;
import management.RecordManager;

public class Driver {
	
	
	public static void main(String[] args) {
		
		try {
			
			RecordManager manager = new RecordManager();
			Student stu_1 = new Student(1031, "Tim", "engineering", 3.1);
			
			manager.loadAll("students.txt");
		
			manager.addStudent(stu_1);
			manager.saveAll("students.txt");
			
			//manager.removeStudent(1005);
			//FileHandler.saveRecords("students.txt", manager.studentsMapToList());
			//manager.saveAll("students.txt");
			
			//manager.studentsMapToList();
			for(Student student : manager.studentsMapToList()) {
				System.out.println(student.toFileFormat());
			}
			
			//manager.saveAll("students.txt");
		}
		catch(FileOperationException e) {
			System.out.println(e.getMessage());
		}

		
	}

}

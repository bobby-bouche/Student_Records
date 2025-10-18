package driver;

import data_classes.Student;
import exceptions.FileOperationException;
import management.RecordManager;

public class Driver {
	
	
	public static void main(String[] args) {
		
		try {
			
			RecordManager manager = new RecordManager();
			Student stu_1 = new Student(1032, "Tony", "engineering", 3.0);
			
			manager.loadAll("students.txt");
		
			manager.addStudent(stu_1);
			manager.saveAll("students.txt");
			
			//manager.removeStudent(1009);
			
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

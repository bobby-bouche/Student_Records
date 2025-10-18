package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import data_classes.Student;
import exceptions.FileOperationException;

public class FileHandler {
	
	
	// constructor
	public FileHandler() {
		super();
	}
	
	
	
	// method to save data to a given file
	public static void saveRecords(String fileName, ArrayList<Student> students) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
			for(int i = 0; i < students.size(); i++) {
				pw.println(students.get(i).toFileFormat());
			}
			pw.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	// method to load data from a given file
	public static ArrayList<Student> loadRecords(String fileName) throws FileOperationException {
		ArrayList<Student> data = new ArrayList<>();
		Student student = null; 
		try (BufferedReader br  = new BufferedReader(new FileReader(fileName))){
			String line;
			while((line = br.readLine()) != null) {
				student = new Student();
				student.fromFileFormat(line);
				data.add(student);
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	
	
	
	
	/*
	 * For a later time...
	 * 
	 * 	public static void updateRecord(?);
	
		public static void deleteRecord(?);
		
		public static void deleteFile(String fileName);
	 */

	
}

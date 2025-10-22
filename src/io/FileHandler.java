package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
		createBackup(fileName);
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
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	
	
	private static void createBackup (String fileName) {
		String backupFile = fileName + ".bak";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName));
			BufferedWriter bw = new BufferedWriter(new FileWriter(backupFile))){

			String line;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public static void serialize(String fileName, ArrayList<Student> students) {
		String serializedFile = fileName + ".ser";
		try(FileOutputStream fileOut = new FileOutputStream(serializedFile);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
			
			for(Student student : students) {
				objOut.writeObject(student);
			}
			
			System.out.println("students serialized successfully.");
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	// hava a quick look at try with resources on youtube
	
	/*
	 * For a later time...
	 * 
	 * 	public static void updateRecord(?);
	
		public static void deleteRecord(?);
		
		public static void deleteFile(String fileName);
	 */

	
}

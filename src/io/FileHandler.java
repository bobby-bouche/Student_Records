package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import data_classes.Student;

public class FileHandler {
	
	
	// constructor
	public FileHandler() {
		super();
	}
	
	
	
	// method to save data to a given file
	public static void saveRecords(String fileName, ArrayList<Student> students) {
		try {
			FileWriter fw  = new FileWriter(fileName, true);
			PrintWriter pw = new PrintWriter(fw);
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
	public static ArrayList<String> loadRecords(String fileName) {
		ArrayList<String> data = new ArrayList<>();
		try {
			FileReader     fr  = new FileReader(fileName);
			BufferedReader br  = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				data.add(line);
				// TODO fromFileFormat();
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return data;
	}
	
	
}

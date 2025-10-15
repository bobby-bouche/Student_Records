package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import data_classes.Person;

public class FileHandler {
	
	
	// constructor
	public FileHandler() {
		super();
	}
	
	
	
	// method to save data to a given file
	public static void saveRecords(String fileName, ArrayList<String> data) {
		try {
			FileWriter fw  = new FileWriter(fileName, true);
			PrintWriter pw = new PrintWriter(fw);
			for(int i = 0; i < data.size(); i++) {
				pw.println(data.get(i));
			}
			pw.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	// method to load data from a given file
	public static void loadRecords(String fileName, ArrayList<String> data) {
		
	}

}

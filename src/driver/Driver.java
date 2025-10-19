package driver;

import java.io.FileNotFoundException;

import io.Keyboard;
import management.RecordManager;

public class Driver {
	
	
	// driver fields
	private static RecordManager manager;
	private static Keyboard kb;
	
	
	
	// constructor
	public Driver() {
		super();
		manager = new RecordManager();
		kb      = new Keyboard();
	}
	
	
	
	// method to initialize program
	/*
	 *  hardcoded now but can build a readFileName() method for kb
	 *  
	 * String fileName = null;
	 * fileName = kb.readFileName();  throws fileNotFoundException to be caught in driver main
	 * manager.loadAll(fileName);
	 */
	private void init() {

		manager.loadAll("students.txt");
		displayMainMenu();
	}
	
	
	
	
	// method to display main user menu
	private void displayMainMenu() {
		
		int choice;
		boolean proceed = true;
		
		String promptMsg = "Make a selection:\n";
		String errorMsg  = "Invalid entry, enter an integer value in the range (1-3)\n";
		
		while(proceed) {
			
			System.out.println("------Student Records Management System------\n"
					   + "--------------Main Menu--------------\n"
					   + "1. Search Menu\n"
					   + "2. Registration Menu\n"
					   + "3. Exit\n");
			
			choice = kb.readInteger(promptMsg, errorMsg, 1, 3);
			
			switch(choice) {
			
				case 1:
					displaySearchMenu();
					break;
					
				case 2:
					displayRegistrationMenu();
					break;
					
				case 3:
					System.out.println("Bye for now!");
					proceed = false;
					break;
					
				default:
					System.out.println(errorMsg + "; " + choice);
				
			}
		}
	}
	
	
	
	private void displaySearchMenu() {}
	
	
	
	
	private void displayRegistrationMenu() {}
	
	
	
	
	public static void main(String[] args) {		
		Driver driver = new Driver();	
		driver.init();
	}

}

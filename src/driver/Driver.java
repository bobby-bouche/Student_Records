package driver;

import java.io.FileNotFoundException;

import data_classes.Student;
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
			
			System.out.println("------ Student Records Management System ------\n\n"
					         + "-------------- Main Menu --------------\n"
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
					manager.saveAll("students.txt");
					proceed = false;
					break;
					
				default:
					System.out.println(errorMsg + "; " + choice);	
			}
		}
	}
	
	
	
	private void displaySearchMenu() {
		
		int choice;
		boolean proceed = true;
		
		String promptMsg = "Make a selection:\n";
		String errorMsg  = "Invalid entry, enter and integer value in the range (1-3)\n";
		
		while(proceed) {
			
			System.out.println("\n------ Student Records Management System ------\n\n"
					         + "-------------- Search Menu --------------\n"
					         + "1. Search student by ID\n"
					         + "2. Display all students\n"
					         + "3. Back\n");
			
			choice = kb.readInteger(promptMsg, errorMsg, 1, 3);
			
			switch(choice) {
			
				case 1:
					int inputId;
					String IdPromptMsg = "enter studentID: \n";
					String IdErrorMsg  = "Invalid id";
					
					inputId = kb.readInteger(IdPromptMsg, IdErrorMsg);
					manager.searchStudentByID(inputId);
					break;
					
				case 2:
					manager.listAllStudents();
					break;
					
				case 3:
					System.out.println("Returning to previous menu..\n\n");
					proceed = false;
					break;
					
				default:
					System.out.println(errorMsg + "; " + choice);	
			}
		}
	}
	
	
	
	
	private void displayRegistrationMenu() {
		
		int choice;
		boolean proceed = false;
		
		String promptMsg = "Make a selection:\n";
		String errorMsg  = "Invalid entry, enter and integer value in the range (1-3)\n";
		
		while(proceed) {
			
			System.out.println("\n------ Student Registration Management System ------\n\n"
			         + "-------------- Search Menu --------------\n"
			         + "1. Register new student\n"
			         + "2. Unregister student\n"
			         + "3. Back\n");
	
			choice = kb.readInteger(promptMsg, errorMsg, 1, 3);
			
			switch(choice) {
			
				case 1:
					// TODO manager.registerNewStudent();
					break;
					
				case 2:
					int studentID;
					String deletePrompt = "enter studentID: ";
					String deleteError  = "Invalid studentID";
					
					studentID = kb.readInteger(deletePrompt, deleteError);
					manager.removeStudent(studentID); // might cause an issue at runtime with a wrong id// input
					break;
					// TODO manager.unregisterStudent();
					
				case 3:
					System.out.println("Returning to previous menu..\n\n");
					proceed = false;
					break;
					
				default:
					System.out.println("Invalid entry");
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {		
		Driver driver = new Driver();	
		driver.init();
	}

}

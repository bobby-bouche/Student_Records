package io;

import java.util.Scanner;

public class Keyboard {

	
	// fields
	private static Scanner input;
	
	
	
	// constructor
	public Keyboard() {
		super();
		input = new Scanner(System.in);
	}
	
	
	
	// input validation methods
	public int readInteger(String promptMsg, String errorMsg, int low, int high) {
		
		int num = 0;
		boolean valid = false;
		String strInput;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				num = Integer.parseInt(strInput);
				if(num > low && num <= high) {
					valid = true;
					break;
				}
				else {
					System.out.println(errorMsg);
				}
			}
			catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		return num;
	}
	
	
	public int reaadInteger(String promptMsg, String errorMsg) {
		
		int num = 0;
		boolean valid = false;
		String strInput;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				num = Integer.parseInt(strInput);
				valid = true;
				break;
			}
			catch(NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}
	
	
	
	public String readString(String promptMsg, String errorMsg) {
		
		String strInput = null;
		boolean valid = false;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				if(!(strInput == null) && !(strInput.isEmpty()) && strInput.matches("^[a-z A-Z 0-9]*$")) {
					valid = true;
					break;
				}
				else {
					System.out.println(errorMsg);
				}
			}
			catch(RuntimeException e) {
				System.out.println(errorMsg);
			}
		}
		return strInput;
	}
	
	
}

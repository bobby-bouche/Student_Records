package driver;

import exceptions.FileOperationException;
import management.RecordManager;

public class Driver {
	
	
	public static void main(String[] args) {
		
		try {
			

			RecordManager manager = new RecordManager();
			
		}
		catch(FileOperationException e) {
			System.out.println(e.getMessage());
		}

		
	}

}

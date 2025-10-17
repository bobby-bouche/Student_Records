package exceptions;

@SuppressWarnings("serial")
public class FileOperationException extends RuntimeException{

	public FileOperationException(String message) {
		super(message);
	}
	
	public FileOperationException(Throwable cause) {
		super(cause);
	}
	
	public FileOperationException(String message, Throwable cause) {
		super(message, cause);
	}
}

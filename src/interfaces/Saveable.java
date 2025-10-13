package interfaces;

public interface Saveable {

	String toFileFormat();
	
	void fromFileFormat(String data);
}

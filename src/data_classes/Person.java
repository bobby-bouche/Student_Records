package data_classes;

public abstract class Person {

	// person fields
	private int id;
	private String name;
	
	
	// symbolic constants
	
	
	
	// constructor
	public Person() {
		super();
	}
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	
	// validations
	// TODO validation methods

	
	
	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	// abstrct methods
	abstract String getDetails();
	
	
	// toString
	@Override
	public String toString() {
		return id + "," + name;
	}
	
}

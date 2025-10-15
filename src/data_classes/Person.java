package data_classes;

public abstract class Person {

	// person fields
	private int id;
	private String name;
	
	
	// symbolic constants
	private static int MIN_ID_VALUE;
	private static int MAX_ID_VALUE;
	private static int NAME_MAX_LENGTH;
	
	
	// initializer
	{
		MIN_ID_VALUE    = 1000;
		MAX_ID_VALUE    = 9999;
		NAME_MAX_LENGTH = 30;
	}
	
	
	// constructor
	public Person() {
		super();
	}
	
	public Person(int id, String name) {
		validateID(id);
		this.id = id;
		validateName(name);
		this.name = name;
	}
	
	
	
	// validations
	private static void validateID(int id) {
		if(id < MIN_ID_VALUE || id > MAX_ID_VALUE) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
	}
	
    private static void validateName(String name) {
        if (name.isBlank() || name == null || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Invalid name: " + name + ". Name must not be blank and must be less than 30 characters.");
        }
    }

	
	
	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		validateID(id);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		validateName(name);
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

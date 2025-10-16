package data_classes;

import enums.Course;
import interfaces.Saveable;

public class Student extends Person implements Saveable {
	
	// student fields
	private String course;
	private double gpa;
	
	
	
	// symbolic constants
	private static String DEFAULT_COURSE;
	private static double DEFAULT_GPA;
	private static double MAX_GPA;
	
	
	
	// initializer
	{
		DEFAULT_COURSE = "N/A";
		DEFAULT_GPA    = 0.0;
		MAX_GPA        = 4.0;
	}
	
	
	
	// constructors
	public Student() {
		super();
	}
	
	public Student(int id, String name, String course) {
		this(id, name, course, DEFAULT_GPA);
	}
	
	public Student(int id, String name, double gpa) {
		this(id, name, DEFAULT_COURSE, gpa);
	}
	
	public Student(int id, String name, String course, double gpa) {
		super(id, name);
		validateCourse(course);
		this.course = course;
		validateGPA(gpa);
		this.gpa    = gpa;
	}
	
	
	
	// validations
	private static void validateCourse(String course) {
		if(!Course.validateCourse(course)) {
			throw new IllegalArgumentException("Error, Invalid course name: " + course);
		}
	}
	
	
	private static void validateGPA(double gpa) {
		if(gpa < DEFAULT_GPA || gpa > MAX_GPA){
			throw new IllegalArgumentException("Error, Invalid gpa: " + gpa);
		}
	}

	
	// getters and setters
	public String getCourse() {
		return course;
	}

	
	public void setCourse(String course) {
		validateCourse(course);
		this.course = course;
	}

	
	public double getGpa() {
		return gpa;
	}
	
	
	public void setGpa(double gpa) {
		validateGPA(gpa);
		this.gpa = gpa;
	}

	
	
    // toString
	@Override
	String getDetails() {
		String studentDetails = this.getId() + "," + this.getName() + "," + course + "," + gpa;
		return studentDetails;
	}

	
	@Override
	public String toFileFormat() {
		return getDetails();
	}


	@Override
	public void fromFileFormat(String data) {
		// TODO Auto-generated method stub
		
	}
	

}

package data_classes;

import interfaces.Saveable;

public class Student extends Person implements Saveable {
	
	// student fields
	private String course;
	private double gpa;
	
	
	
	// symbolic constants
	private static String default_course;
	private static double default_gpa;
	
	
	
	// initializer
	{
		default_course = "n/a";
		default_gpa    = 0.0;
	}
	
	
	
	// constructors
	public Student() {
		super();
	}
	
	public Student(String course) {
		this(course, default_gpa);
	}
	
	public Student(double gpa) {
		this(default_course, gpa);
	}
	
	public Student(String course, double gpa) {
		this.course = course;
		this.gpa    = gpa;
	}
	
	
	// validations
	// TODO validation methods
	

	
	// getters and setters
	public String getCourse() {
		return course;
	}

	
	public void setCourse(String course) {
		this.course = course;
	}

	
	public double getGpa() {
		return gpa;
	}
	
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	
	
    // toString
	@Override
	String getDetails() {
		String studentDetails = "Student [course=" + course + ", gpa=" + gpa + "]";
		return studentDetails;
	}

	
	@Override
	public String toFileFormat() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void fromFileFormat(String data) {
		// TODO Auto-generated method stub
		
	}
	

}

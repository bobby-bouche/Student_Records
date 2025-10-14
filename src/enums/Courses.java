package enums;

public enum Courses {
	
	// course list
    COMPUTER_SCIENCE ("computer_science"),
    MATHEMATICS ("mathematics"),
    PHYSICS("physics"),
    HISTORY("history"),
    ENGINEERING("engineering"),
    BIOLOGY("biology"),	
    ECONOMICS("economics"),
	NOT_APPLICABLE("not_applicable");
	
	
	
	// course variable 
	private String course;
	
	
	
	// constructor
	Courses(String course){
		this.setCourse(course);
	}


	
	// getter and setter
	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}
	
	
	public static Courses validateCourse(String inputCourse) {
		for(Courses course : Courses.values()) {
			if(course.course.equalsIgnoreCase(inputCourse)) {
				return course;
			}
		}
		return Courses.NOT_APPLICABLE;
	}

}

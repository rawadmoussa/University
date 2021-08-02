package lab4;

import java.util.ArrayList;

class Faculty extends Person { // Faculty class as subclass of person
	String employeeId;
	ArrayList<Course> teachingSchedule = new ArrayList<Course>();

	public Faculty(String name, Address address, String facultyId) {
		super(name, address);
		this.employeeId = facultyId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setFacultyId(String facultyId) {
		this.employeeId = facultyId;
	}

	public ArrayList<Course> getTeachingSchedule() {
		return teachingSchedule;
	}

	public void setTeachingSchedule(ArrayList<Course> teachingSchedule) {
		this.teachingSchedule = teachingSchedule;
	}

	public void teachNewCourse(Course course) {
		teachingSchedule.add(course);
	}

	public void removeCourse(Course course) {
		teachingSchedule.remove(course);
	}
	 public String toString() {
			return "the faculty member ID is : " + this.employeeId;
	 }
}
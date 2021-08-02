package lab4;

import java.util.ArrayList;

public class Student extends Person{ //Student class as subclass of Person


    private String studentCIN;
    ArrayList<Course> courseSchedule = new ArrayList<Course>();

    public Student(String name, Address address, String studentCIN) {
        super(name, address);
        this.studentCIN = studentCIN;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public String getStudentCIN() {
        return studentCIN;
    }

    public void setStudentCIN(String studentCIN) {
        this.studentCIN = studentCIN;
    }

    public ArrayList<Course> getCourseSchedule() {
        return courseSchedule;
    }

    public void setCourseSchedule(ArrayList<Course> courseSchedule) {
        this.courseSchedule = courseSchedule;
    }

    public void addCourse(Course course){
        courseSchedule.add(course);
    }

    public void removeCourse(Course course){
        courseSchedule.remove(course);
    } 
    public String toString() {
		return "the student's CIN is " + this.studentCIN + " ";
    }
}
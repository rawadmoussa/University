package lab4;

public class Course {
	private String courseId;
    private int numberOfUnits;

    public Course(String courseId, int numberOfUnits) {
        this.courseId = courseId;
        this.numberOfUnits = numberOfUnits;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
    public String toString() {
		return  this.courseId + " ";
    }
}

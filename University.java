package lab4;


	import java.util.Scanner;
	import java.util.ArrayList;

	public class University {
		Scanner in = new Scanner(System.in);
		ArrayList<Student> studList = new ArrayList<Student>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
		public void addStudent() {
			String name;
			String cIN;
			Address address = new Address(0, null, null, null, null);
			System.out.println("Enter Student Details:");
			System.out.println("Name:");
			name = in.next();
			System.out.println("Street Number:");
			address.setStreetNumber(in.nextInt());
			System.out.println("Street Name:");
			address.setStreetName(in.next());
			System.out.println("City:");
			address.setCity(in.next());
			System.out.println("State:");
			address.setState(in.next());
			System.out.println("Country:");
			address.setCountry(in.next());
			System.out.println("CIN:");
			cIN = in.next();
			Student student = new Student(name, address, cIN);
			studList.add(student);
		}

		public void addFaculty() {
			String name;
			String facultyId;
			Address address = new Address(0, "", "", "", "");
			System.out.println("Enter faculty member Details:");
			System.out.println("Name:");
			name = in.next();
			System.out.println("Street Number:");
			address.setStreetNumber(in.nextInt());
			System.out.println("Street Name:");
			address.setStreetName(in.next());
			System.out.println("City:");
			address.setCity(in.next());
			System.out.println("State:");
			address.setState(in.next());
			System.out.println("Country:");
			address.setCountry(in.next());
			System.out.println("FacultyId:");
			facultyId = in.next();
			Faculty faculty = new Faculty(name, address, facultyId);
			facultyList.add(faculty);
			;
		}

		public void addCourseToCourseList() {
			String courseId;
			int numberOfUnits;
			System.out.println(" Enter the course details : ");
			System.out.println();
			System.out.println(" Enter the course Id in this format (subject_course number : ");
			courseId = in.next();
			System.out.println(" Enter the number of units : ");
			numberOfUnits = in.nextInt();
			Course course = new Course(courseId, numberOfUnits);
			courseList.add(course);
		}

		public ArrayList<Student> getStudList() {
			for (Student student : studList) {
				System.out.println(" the student's name is " + student.getName() + " , the address is : "
						+ student.getAddress() + ", the class schedule is : " + student.getCourseSchedule()
						+ ", and the student CIN is " + student.getStudentCIN());
				System.out.println();
			}
			return studList;
		}

		public void setStudList(ArrayList<Student> studList) {
			this.studList = studList;
		}

		public ArrayList<Faculty> getFacultyList() {
			for (Faculty faculty : facultyList) {
				System.out.println(" the faculty member's name is " + faculty.getName() + ", the address is "
						+ faculty.getAddress() + " the teaching schedule is " + faculty.getTeachingSchedule() + ", and the employee ID is " + faculty.getEmployeeId());
				System.out.println();
			}
			return facultyList;
		}

		public void setFacultyList(ArrayList<Faculty> facultyList) {
			this.facultyList = facultyList;
		}

		public ArrayList<Course> getCourseList() {
			for (Course course : courseList) {
				System.out.println("course's ID is " + course.getCourseId() + " and the number of units is "
						+ course.getNumberOfUnits());
				System.out.println();
			}
			return courseList;
		}

		public void setCourseList(ArrayList<Course> courseList) {
			this.courseList = courseList;
		}

		public void removeStudent() {
			String CIN;
			System.out.println("Enter the CIN of the student you would like to remove : ");
			CIN = in.next();
			int student = 0;
			for (Student s: studList) {
			    if (s.getStudentCIN().equals(CIN)) {
			       break;
			    }
			    else student++;
			}
			studList.remove(student);
		}
		

		public void removeFaculty() {
			String employeeID;
	        System.out.println("Enter the Id of faculty to remove:");
	        employeeID=in.next();
	        int faculty = 0;
			for (Faculty f: facultyList) {
			    if (f.getEmployeeId().equals(employeeID)) {
			       break;
			    }
			    else faculty++;
			}
			studList.remove(faculty);
		}
	
			
		

		public void addCourseForStudents() {
			String CIN;
			System.out.println("please enter your CIN : ");
			CIN = in.next();
			for (Student s : studList) {
				if (s.getStudentCIN().equals(CIN)) {
					outerLoopToAddCourse(s);
				}
			}
		}

		public void outerLoopToAddCourse(Student s) {
			String courseId;
			int numberOfUnits;
			System.out.println(" Enter the course details : ");
			System.out.println();
			System.out.println(" Enter the course Id : ");
			courseId = in.next();
			System.out.println(" Enter the number of units : ");
			numberOfUnits = in.nextInt();
			for (Course c : courseList) {
				if (c.getCourseId().equals(courseId) && numberOfUnits == c.getNumberOfUnits()) {
					s.courseSchedule.add(c);

				} else
					continue;
			}

		}

		public void removeCourseForStudents() {
			String CIN;
			System.out.println("please enter your CIN : ");
			CIN = in.next();
			for (Student s : studList) {
				if (s.getStudentCIN().equals(CIN)) {
					s.getCourseSchedule();
					outerLoopToRemoveCourse(s);
				}
			}

		}

		public void outerLoopToRemoveCourse(Student s) {
			String courseId;
			int numberOfUnits;
			System.out.println(" Enter the course details : ");
			System.out.println();
			System.out.println(" Enter the course Id : ");
			courseId = in.next();
			System.out.println(" Enter the number of units : ");
			numberOfUnits = in.nextInt();
			for (Course c : s.courseSchedule) {
				if (c.getCourseId().equals(courseId) && numberOfUnits == c.getNumberOfUnits()) {
					s.courseSchedule.remove(c);
					break;
				} else
					continue;
			}

		}

		public void addCourseForFaculty() {
			String employeeId;
			System.out.println("please enter your employee ID : ");
			employeeId = in.next();
			for (Faculty f : facultyList) {
				if (f.getEmployeeId().equals(employeeId)) {
					outerLoopToAddCourse(f);
				}
			}
		}

		public void outerLoopToAddCourse(Faculty f) {
			String courseId;
			int numberOfUnits;
			System.out.println(" Enter the course details : ");
			System.out.println();
			System.out.println(" Enter the course Id : ");
			courseId = in.next();
			System.out.println(" Enter the number of units : ");
			numberOfUnits = in.nextInt();
			for (Course c : courseList) {
				if (c.getCourseId().equals(courseId) && numberOfUnits == c.getNumberOfUnits()) {
					f.teachingSchedule.add(c);
				}
			}
		}

		public void removeCourseForFaculty() {
			String employeeId;
			System.out.println("please enter your CIN : ");
			employeeId = in.next();
			for (Faculty f : facultyList) {
				if (f.getEmployeeId().equals(employeeId)) {
					f.getTeachingSchedule();
					outerLoopToRemoveCourse(f);
				}
			}

		}

		public void outerLoopToRemoveCourse(Faculty f) {
			String courseId;
			int numberOfUnits;
			System.out.println(" Enter the course details : ");
			System.out.println();
			System.out.println(" Enter the course Id : ");
			courseId = in.next();
			System.out.println(" Enter the number of units : ");
			numberOfUnits = in.nextInt();
			for (Course c : f.teachingSchedule) {
				if (c.getCourseId().equals(courseId) && numberOfUnits == c.getNumberOfUnits()) {
					f.teachingSchedule.remove(c);
					break;
				} else
					continue;
			}

		}

		{
			int choice;
			do {
				printMenu();
				choice = in.nextInt();
				switch (choice) {
				case 1:
					addStudent();
					break;
				case 2:
					addFaculty();
					break;
				case 3:
					addCourseToCourseList();
					break;
				case 4:
					if(!studList.isEmpty()) {
						setStudList(studList);
						getStudList();
					}
					else System.out.print("No students to show");
					break;
				case 5:
				if(!facultyList.isEmpty()) {
				setFacultyList(facultyList);
					getFacultyList();}
				else System.out.print("No Faculties to show");
					
					break;
				case 6:
				if(!courseList.isEmpty()) {
					setCourseList(courseList);
					getCourseList();
				}
				else System.out.println("No courses to show");
					
					break;
				case 7:
					getStudList();
					removeStudent();
					break;

				case 8:
					getFacultyList();
					removeFaculty();
					break;
				case 9:getStudList();
					addCourseForStudents();
					break;
				case 10:getStudList();
					removeCourseForStudents();
					break;
				case 11:
					getFacultyList();
					addCourseForFaculty();
					break;
				case 12:getFacultyList();
					removeCourseForFaculty();
					break;

				case 13:
					System.out.println("Goodbye");
					System.exit(0);
					break;

				}
			} while (choice != 0);

		}

		public void printMenu() {
			System.out.println("Menu:");
			System.out.println("1.Add Student to list of students");
			System.out.println("2.Add Faculty to list of faculty:");
			System.out.println("3.Add course to list of courses");
			System.out.println("4.Display Students");
			System.out.println("5.Display Faculties");
			System.out.println("6.Display Courses");
			System.out.println("7.Remove Student from list of students");
			System.out.println("8.Remove Faculty from list of faculty");
			System.out.println("9.Add Course to your course schedule (for students ) ");
			System.out.println("10.Remove Course from your course schedule (for students ) ");
			System.out.println("11.Add Course to your teaching schedule (for faculty members )  ");
			System.out.println("12.Remove Course from your teaching schedule (for faculty members ) ");
			System.out.println("13.Exit");
			System.out.println("Enter Your Choice:");
		}
	}


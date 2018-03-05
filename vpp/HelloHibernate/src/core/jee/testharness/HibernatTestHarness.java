package core.jee.testharness;

import org.hibernate.Session;

import core.jee.domain.Student;

public class HibernatTestHarness {

	public static void main(String[] args) {
		Student testStudent = new Student("Jessica Ennis", "Toni Minichiello");
		
		System.out.println(testStudent + " has a grade point of " + testStudent.calculateGradePointAverage());
		
		// save the student to database
		Session session;
		
		session.save(testStudent);

	}

}

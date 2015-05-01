import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.TestCase;
/**
 * JUnit tests for Student and Course
 * @author dshook
 *
 */
public class StudentAndCourseTest extends TestCase {
    @Test
    // this really needs to be broken up in a set of smaller tests
	public void testStudentInit() {
		Student s = new Student("Doug", "Shook", 111111);
		assertEquals("Doug Shook", s.getName());
		assertEquals(111111, s.getStudentID());
		//No credits, no GPA
		assertEquals(0.0, s.getGPA());
		assertEquals(0, s.getCredits());

		//Generate some random students, and test
		for (int i = 0; i < 20; ++i) {
			double a = (Math.random() * 5000);
			double b = (Math.random() * 5000);
			int c = (int) (Math.random() * 5000);
			Student s3 = new Student("" + a, "" + b, c);

			assertEquals(a + " " + b, s3.getName());
			assertEquals(0.0, s3.getGPA());
			assertEquals(0, s3.getCredits());
			assertEquals(a + " " + b + ", " + c, s3.toString());

			int hours = (int) (Math.random() * 120);
			s3.setCredits(hours);
			if (hours >= 90)
				assertEquals("Senior", s3.getClassStanding());
			else if (hours >= 60)
				assertEquals("Junior", s3.getClassStanding());
			else if (hours >= 30)
				assertEquals("Sophomore", s3.getClassStanding());
			else
				assertEquals("Freshman", s3.getClassStanding());

			Student parent2 = new Student("First", "Last", 100001);
			parent2.setGPA(Math.random() * 4.0);
			s3.setGPA(Math.random() * 4.0);
			Student legacy = s3.createLegacy(parent2);
			assertEquals(a + " " + "Last", legacy.getName());
			assertTrue(legacy.getStudentID() >= 100000);


			assertTrue(legacy.getGPA() <= Math.max(s3.getGPA(), parent2.getGPA()));
			assertTrue(legacy.getGPA() >= Math.min(s3.getGPA(), parent2.getGPA()));
		}

		double gpa = Math.random() * 4.0;
		double grade = Math.random() * 4.0;
		double credits = Math.random() * 5.0;
		Student s4 = new Student("wailey", "wailey", 42);
		s4.setCredits(0);
		s4.setGPA(0.0);
		s4.submitGrade(0.0, 0);
		assertEquals(0.0, s4.getGPA(), 4);
		Student s5 = new Student("uncutable", "cord", 1);
		s5.setCredits(10000);
		s5.setGPA(4.0);
		s5.submitGrade(4.0, 5);
		assertEquals(4.0, s5.getGPA(), 4);
		Student s6 = new Student("roundoff", "error", 63);
		s6.setCredits(0);
		s6.setGPA(0.0);
		s6.submitGrade(1.0, 10);
		assertEquals(0.1, s6.getGPA(), 1);

		Student s7 = new Student("How", "Much", 20000);
		assertEquals(0, s7.computeTuition());
		Student s8 = new Student("Unforgiveable", "debt", 999);
		s8.setCredits(500);
		assertEquals(660000, s8.computeTuition());
		Student s9 = new Student("over", "half", 499);
		s9.setCredits(23);
		assertEquals(40000, s9.computeTuition());
		Student s10 = new Student("grad", "ontime", 12345);
		s10.setCredits(120);
		assertEquals(160000, s10.computeTuition());
	}

	@Test
	public void testCourseInit() {
		Course c1 = new Course("Basket Weaving", 1, 10);
        assertNotNull(c1);
	}

	@Test
	public void testCourseAddStudent() {
		Course c1 = new Course("Basket Weaving", 1, 10);
		Student temp = new Student("first", "dibs", 1);
		c1.addStudent(temp);

		// generate 2 less then a full class number of random students
		Student[] debtors = new Student[8];
		for (int i = 0; i < 8; i++) {
			int a = (int) (Math.random() * 1000000) + 1;
			int b = (int) (Math.random() * 1000000) + 1;
			int id = (int) (Math.random() * 900000) + 100000;
			debtors[i] = new Student("" + a, "" + b, id);
		}

		// put butts in seats (leaving one seat) with students from array
		for (Student iou : debtors) {
			assertTrue(c1.addStudent(iou));
		}

		// try to add the same student again
		temp = debtors[0];
		assertFalse(c1.addStudent(temp));

		// fill up the class then try to add yet another studen
		temp = new Student("fill", "class", 10);
		assertTrue(c1.addStudent(temp));
		temp = new Student("attempt", "over", 11);
		assertFalse(c1.addStudent(temp));
	}

	@Test
	public void testCourseToString() {
		Course c1 = new Course("Basket Weaving", 1, 10);
		assertEquals("Basket Weaving 1", c1.toString());
	}

    @Test
    public void testCoursePrintRosterEmpty() {
        Course c1 = new Course("Basket Weaving", 1, 5);
        System.out.println("Program should print no pupils");
        c1.printRoster();
    }

	@Test
	public void testCoursePrintRosterNotFull() {

		// Create a not full class and print them
		Course c1 = new Course("Basket Weaving", 1, 5);
		Student s1 = new Student("pupil", "one", 1);
		Student s2 = new Student("pupil", "two", 2);
		Student s3 = new Student("pupil", "three", 3);
		c1.addStudent(s1);
		c1.addStudent(s2);
		c1.addStudent(s3);

		System.out.println("Program should print pupils one to three");
		c1.printRoster();
	}

	@Test
	public void testCoursePrintRosterIsFull() {

		// Create a not full class and print them
		Course c1 = new Course("Basket Weaving", 1, 5);
		Student s1 = new Student("pupil", "one", 1);
		Student s2 = new Student("pupil", "two", 2);
		Student s3 = new Student("pupil", "three", 3);
		Student s4 = new Student("pupil", "four", 4);
		Student s5 = new Student("pupil", "five", 5);
		c1.addStudent(s1);
		c1.addStudent(s2);
		c1.addStudent(s3);
		c1.addStudent(s4);
		c1.addStudent(s5);

		System.out.println("Program should print pupils one to five");
		c1.printRoster();
	}

    @Test
    public void testCourseAverageGPAempty() {
        Course c1 = new Course("testing", 5, 100);
        assertEquals(c1.averageGPA(), 0.0, 5);
    }

    @Test
    public void testCourseAverageGPAnotFull() {
        Course c1 = new Course("testing", 5, 100);
        // generate 2 less then a full class number of random students
        Student[] debtors = new Student[98];
        for (int i = 0; i < 98; i++) {
            int a = (int) (Math.random() * 1000000) + 1;
            int b = (int) (Math.random() * 1000000) + 1;
            int id = (int) (Math.random() * 900000) + 100000;
            debtors[i] = new Student("" + a, "" + b, id);
        }
        // put butts in seats (leaving two open seats) with students from array
        for (Student iou : debtors) {
            c1.addStudent(iou);
        }

        // check that default gpas of 0.0 average to 0
        assertEquals(c1.averageGPA(), 0.0, 5);

        // assign random GPAs to students and check that average is in range
        for (Student iou:debtors) {
            iou.setGPA(Math.random() * 4.0);
        }
        assertTrue(c1.averageGPA() < 4.0);
        assertTrue(c1.averageGPA() > 0.0);
    }

    @Test
    public void testCourseAverageGPAisFull() {
        Course c1 = new Course("testing", 5, 100);
        // generate a full class number of random students
        Student[] debtors = new Student[100];
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 1000000) + 1;
            int b = (int) (Math.random() * 1000000) + 1;
            int id = (int) (Math.random() * 900000) + 100000;
            debtors[i] = new Student("" + a, "" + b, id);
        }
        // put butts in seats with students from array
        for (Student iou : debtors) {
            c1.addStudent(iou);
        }

        // check that default gpas of 0.0 average to 0
        assertEquals(c1.averageGPA(), 0.0, 5);

        // assign random GPAs to students and check that average is in range
        for (Student iou:debtors) {
            iou.setGPA(Math.random() * 4.0);
        }
        assertTrue(c1.averageGPA() < 4.0);
        assertTrue(c1.averageGPA() > 0.0);
    }
}



import junit.framework.TestCase;
import org.junit.Test;

/**
 * JUnit tests for Student and Course
 * @author Sean Murphy
 *
 */
public class StudentFullandPartTest extends TestCase {
    @Test
	public void testFullTimeStudentInit() {
		Student s = new FullTimeStudent("Doug", "Shook", 111111);
		assertEquals("Doug Shook", s.getName());
		assertEquals(111111, s.getIDnumber());
		// initialized with no credits, no GPA
		assertEquals(0.0, s.getGPA());
		assertEquals(0, s.getCredits());
	}

	@Test
	public void testPartTimeStudentInit() {
		Student s = new PartTimeStudent("Arthur", "Dent", 42);
		assertEquals("Arthur Dent", s.getName());
		assertEquals(42, s.getIDnumber());
		// initialized with no credits, no GPA
		assertEquals(0.0, s.getGPA());
		assertEquals(0, s.getCredits());
	}

	@Test
	public void testFullTimeTuition() {
		Student s = new FullTimeStudent("Trillian", "McMillian", 1000001);
		s.setCredits(93);
		assertEquals(120000, s.computeTuition());
	}

	@Test
	public void testPartTimeTuition() {
		Student s = new PartTimeStudent("Zaphod", "Beeblebrox", 1);
		s.setCredits(93);
		assertEquals(27900, s.computeTuition());
	}
}



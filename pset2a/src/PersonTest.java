/**
 * Created by sean on 5/4/15.
 */
import junit.framework.TestCase;
import org.junit.Test;

/**
 * JUnit tests for Student and Course
 * @author Sean Murphy
 *
 */
public class PersonTest extends TestCase {
    @Test
    public void testPersonInit() {
        Person p1 = new Person("Ford", "Prefect", 5);
        assertNotNull(p1);
        assertEquals("Ford Prefect", p1.getName());
        assertEquals(5, p1.getIDnumber());
    }
}
/**
 * Created by Sean Murphy on 5/4/15.
 */

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * JUnit tests for Instructor
 */
public class InstructorTest extends TestCase {
    @Test
    public void testInstructorInit() {
        Instructor i1 = new Instructor("Doug", "Shook", 111111);
        assertEquals("Doug Shook", i1.getName());
        assertEquals(111111, i1.getIDnumber());
    }
}
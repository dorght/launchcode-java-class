import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by sean on 5/13/15.
 */
public class QuizTest extends TestCase {
    @Test
    public void testQuizSize1() {
        Quiz touring = null;

        try {
            touring = new Quiz(1);
        } catch (Quiz.QuizLengthException e) {
            System.out.println("Quiz must have a length greater then 0!");
        }
        assertNotNull(touring);
    }

    @Test
    public void testQuizSize0() {
        Quiz studentT = null;

        try {
            studentT = new Quiz(1);
        } catch (Quiz.QuizLengthException e) {
            System.out.println("Quiz must have a length greater then 0!");
        }
        assertNull(studentT);
    }

    @Test
    public void testQuizSizeNeg5() {
        Quiz teacherT = null;

        try {
            teacherT = new Quiz(-5);
        } catch (Quiz.QuizLengthException e) {
            System.out.println("Quiz must have a length greater then 0!");
        }
        assertNull(teacherT);
    }
}



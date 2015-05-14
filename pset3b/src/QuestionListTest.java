import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Sean on 5/13/15.
 */
public class QuestionListTest extends TestCase {
    @Test
    public void testQuestionListNoFile() {
        ArrayList<Question> questions = QuestionList.listFromFile("badfilename");
        assertTrue(questions.isEmpty());
    }

    @Test
    public void testQuestionListFileEmpty() {
        ArrayList<Question> questions = QuestionList.listFromFile("/Users/sean/Programming/Java/launchcode-java-class/pset3b/src/EmptyTestFile.txt");
        assertTrue(questions.isEmpty());
    }

    @Test
    public void testQuestionListGoodFile() {
        ArrayList<Question> questions = QuestionList.listFromFile("/Users/sean/Programming/Java/launchcode-java-class/pset3b/src/Test3Questions.txt");
        assertEquals(3, questions.size());
    }
}

/**
 * Created by sean on 5/4/15.
 */
public class MultipleChoiceQ extends Question {

    public MultipleChoiceQ(String question, String[] possibilites, String answer) {
        super(question, possibilites, answer);
        title = "Multiple Choice";
        initialSelection = null;
    }
}

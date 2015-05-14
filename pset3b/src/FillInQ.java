/**
 * Created by sean on 5/4/15.
 */
public class FillInQ extends Question{

    public FillInQ(String question, String answer) {
        super(question, null, answer);
        title = "Fill In the Blank";
        initialSelection = "Spelling counts";
    }
}

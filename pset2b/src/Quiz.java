import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Sean on 5/4/15.
 */
public class Quiz {
    private int quizlength;
    private double score = 0.0;


    public Quiz(int quizlength) {
        this.quizlength = quizlength;
    }

    private double startQuiz() {
        double scorevalue = 1.0 / quizlength;
        ArrayList<Question> questions = Question.listFromFile("./pset2b/src/Questions.txt");

        while (questions.size() > 0 && quizlength-- > 0) {
            int index = (int) (Math.random() * questions.size());
            Question question = questions.get(index);
            String useranswer = question.displayQuestion();

            if (question.checkAnswer(useranswer))
                this.score += scorevalue;
            questions.remove(index);
        }
        return this.score;
    }

    public void displayScore(double score) {
        String scoremessage = "Your score is: " + Math.round(score * 100.0) + "%";

        JOptionPane.showMessageDialog(
                null,                            // Component parentComponent
                scoremessage,                    // Object message
                "Your Score",                    // String title
                JOptionPane.PLAIN_MESSAGE        // int messageType
        );
    }

    public static void main (String[] args) {
        int QUIZLENGTH = 5;

        Quiz quiz = new Quiz(QUIZLENGTH);

        double score = quiz.startQuiz();
        quiz.displayScore(score);
    }
}

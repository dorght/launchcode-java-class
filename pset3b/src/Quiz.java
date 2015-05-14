import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Sean on 5/4/15.
 */
public class Quiz {
    private int quizlength;
    private double score = 0.0;

    /**
     * Constructor for Quiz(int)
     * @param quizlength is the number of questions to be asked during the quiz
     * @throws QuizLengthException if quizlength is less then 1
     */
    public Quiz(int quizlength) throws QuizLengthException {
        if (quizlength <= 0)
            throw new QuizLengthException();
        this.quizlength = quizlength;
    }

    /**
     * startQuiz() method initializes and administers the quiz
     * @return double score, the users total quiz score as a fraction (not percentage)
     */
    private double startQuiz() {
        double scorevalue = 1.0 / this.quizlength;

        // generate an ArrayList of questions using the filename parameter as the source file
        ArrayList<Question> questions = QuestionList.listFromFile("./pset3b/src/Questions.txt");

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


        Quiz quiz = null;

        try {
            quiz = new Quiz(QUIZLENGTH);
        } catch (QuizLengthException e) {
            System.out.println("Quiz must have a length greater then 0!");
        }

        double score = quiz.startQuiz();
        quiz.displayScore(score);
    }

    public class QuizLengthException extends Throwable {
    }
}

/**
 * Created by Sean on 5/4/15.
 */

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Question {
    String answer;
    String question;
    String title;
    String[] possibilities;
    String initialSelection;

    /**
     * Constructor for Question(String, String[], String)
     * @param question is the text of the question to be presented
     * @param possibilites is an array of possible answers for multichoice answers (default to null for question types)
     * @param answer is the text of the correct answer
     */
    public Question(String question, String[] possibilites, String answer) {
        this.question = question;
        this.possibilities = possibilites;
        this.answer = answer;
    }

    public String displayQuestion() {
        String useranswer = (String) JOptionPane.showInputDialog(
                null,                           // Component parentComponent
                this.question,                  // Object message
                this.title,                     // String title
                JOptionPane.PLAIN_MESSAGE,      // int messageType
                null,                           // Icon icon
                this.possibilities,             // Object[] selectionValues (null will make it a text entry field)
                this.initialSelection);         // Object initialSelectionValue
        return useranswer;
    }

    public boolean checkAnswer(String useranswer) {
         return (this.answer.equals(useranswer));
    }

}


/**
 * Created by sean on 5/4/15.
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question {
    String answer;
    String question;
    String title;
    String[] possibilities;
    String initialSelection;

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

    public static ArrayList<Question> listFromFile(String filename) {

        ArrayList<Question> questionslist = new ArrayList<Question>();
        File questionsource = new File(filename);
        String[] lines;

        try {
            BufferedReader readin = new BufferedReader(new FileReader(questionsource));

            String line;

            while ((line = readin.readLine()) != null) {
                lines = line.split("\", \"|, \"|\", answer: \"");
                int questiontype = 0;
                int answer = lines.length - 1;

                lines[answer] = lines[answer].replaceAll("\"$", "");

                if (lines[questiontype].equals("FillInQ")) {
                    questionslist.add(new FillInQ(lines[1], lines[answer]));
                }
                else if (lines[questiontype].equals("QuantitativeQ")) {
                    questionslist.add(new QuantitativeQ(lines[1], lines[answer]));
                }
                else if (lines[questiontype].equals("MultipleChoiceQ")) {
                    String[] possible;
                    possible = Arrays.copyOfRange(lines, 2, answer);
                    questionslist.add(new MultipleChoiceQ(lines[1], possible, lines[answer]));
                }
            }
            readin.close();
        } catch (Exception e) {
            System.out.println("Could not open file: " + questionsource);
        }
        return questionslist;
    }
}


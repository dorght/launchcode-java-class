import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Sean on 5/13/15.
 */
public class QuestionList {

    /**
     * listFromFile(String) method: creates an ArrayList of questions, choices, and answer from a source file
     * @param filename path/name of the file to be read as the source of questions
     * @return ArrayList of questions along with its choices and answers
     */
    public static ArrayList<Question> listFromFile(String filename) {
        ArrayList<Question> questionslist = new ArrayList<Question>();

        File questionsource = new File(filename);
        String[] lines;

        try {
            BufferedReader readin = new BufferedReader(new FileReader(questionsource));

            String line;

            // read through file a line at a time and parse out question, choices, and answer
            while ((line = readin.readLine()) != null) {
                // break up lines from the file at   ", "   or   , "   or    answer: \"   substrings are found
                lines = line.split("\", \"|, \"|\", answer: \"");

                // create names for array indices
                int questiontype = 0;
                int answer = lines.length - 1;

                // strip trailing quote from answer
                lines[answer] = lines[answer].replaceAll("\"$", "");

                // generate question object instances and add them to the question list
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
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file: " + questionsource);
        } catch (IOException e) {
            System.out.println("File error: " + e);
        }
        return questionslist;
    }
}

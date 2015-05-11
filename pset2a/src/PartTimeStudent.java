/**
 * Created by sean on 5/4/15.
 */
public class PartTimeStudent extends Student {
    // according to spec average tuition is $300 per credit hour
    private final int HOURLY_TUITION = 300;

    public PartTimeStudent(String fname, String lname, int studentID) {
        super(fname, lname, studentID);
    }

    /**
     * computeTuition()
     * @return returns an integer approximation of the total tuition expense of a student based on their credit hours
     */
    public int computeTuition() {
        int tuition = getCredits() * HOURLY_TUITION;     // integer divide is intentional

        return tuition;
    }

}
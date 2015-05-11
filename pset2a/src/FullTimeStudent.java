/**
 * Created by Sean Murphy on 5/4/15.
 */
public class FullTimeStudent extends Student {
//    according to spec averages are tuition is $20,000 per semester and 15 credit hours per semester
//    private final int AVG_TUITION = 20000;
//    private final int AVG_HOURS = 15;

    public FullTimeStudent(String fname, String lname, int studentID) {
        super(fname, lname, studentID);
    }

    /**
     * computeTuition()
     * @return returns an integer approximation of the total tuition expense of a student based on their credit hours
     */
//    public int computeTuition() {
//        int tuition = (getCredits() / AVG_HOURS) * AVG_TUITION;     // integer divide is intentional
//        // if greater then 1/2 a semester's credits remain tack on another semesters worth of tuition
//        if (getCredits() % AVG_HOURS > (AVG_HOURS / 2))
//            tuition += AVG_TUITION;
//
//        return tuition;
//    }

}

/**
 * Created by Sean Murphy on 4/28/15
 */
public class Student extends Person {
    private double gpa;
    private int credits;
    // according to spec averages are tuition is $20,000 per semester and 15 credit hours per semester
    private final int AVG_TUITION = 20000;
    private final int AVG_HOURS = 15;

    /**
     * Constructor for Student object
     * @param fname     string containing first name to use for student
     * @param lname     string containing last name to use for student
     * @param studentID integer number to brand the student as just another number
     */
    public Student(String fname, String lname, int studentID) {
        super(fname, lname, studentID);
        // initialize values to 0
        this.gpa = 0.0;
        this.credits = 0;
    }

    public double getGPA() {
        return this.gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * toString()
     * @return  returns a string that contains the students name and student id
     */
    public String toString() {
        return (getName() + ", " + getIDnumber());
    }

    /**
     * getClassStanding()
     * @return  returns a string containing the class ranking of the student based on their total course credits
     */
     public String getClassStanding() {
        if (this.credits >= 90)
            return "Senior";
        else if (this.credits >= 60)
            return "Junior";
        else if (this.credits >= 30)
            return "Sophomore";
        else
            return "Freshman";
    }

    /**
     * submitGrade()
     * @param grade   double numeric value that will be used to update students GPA
     * @param hours   integer numeric value of the course's credit hours
     */
    public void submitGrade(double grade, int hours) {
        double quality = this.gpa * this.credits;
        this.credits += hours;
        if (this.credits != 0)
            this.gpa = (quality + grade) / this.credits;
        else
            this.gpa = 0.0;
    }

    public int computeTuition() {
        int tuition = (getCredits() / AVG_HOURS) * AVG_TUITION;     // integer divide is intentional
        // if greater then 1/2 a semester's credits remain tack on another semesters worth of tuition
        if (getCredits() % AVG_HOURS > (AVG_HOURS / 2))
            tuition += AVG_TUITION;

        return tuition;
    }
    /**
     * createLegacy()
     * @param parent2   a Student object that contains the other parent of the legacy to be created
     * @return          returns a Student object containing a legacy student created from this.student and parent2
     */
    public Student createLegacy(Student parent2) {
        // use this.student's first name for legacy's first name
        String fname = this.getName();
        String[] name = fname.split(" ");
        fname = name[0];

        // use parent passed as parameter last name as legacy's last name
        String lname = parent2.getName();
        name = lname.split(" ");
        lname = name[1];

        // create a random 6 digit student id
        int id = (int)(Math.random() * 90000) + 100000;

        // create legacy student
        Student legacy = new Student(fname, lname, id);

        // set GPA to average of parent's GPAs
        legacy.setGPA((this.getGPA() + parent2.getGPA()) / 2);

        // use highest of the two parents to set credit hours
        legacy.setCredits(Math.max(this.getCredits(), parent2.getCredits()));

        return legacy;
    }
}

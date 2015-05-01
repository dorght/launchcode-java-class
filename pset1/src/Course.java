/**
 * Created by Sean Murphy on 4/30/15.
 */
public class Course {

    private String name;
    private int credits;
    private int seats;
    private Student[] roster;

    /**
     * Constructor for Course object
     * @param name      a string containing the name of the course
     * @param credits   an integer value of the credit hours to be given for the course
     * @param seats     an integer count of total number of seats in the classroom
     */
    public Course(String name, int credits, int seats) {
        this.name = name;
        this.credits = credits;
        this.seats = seats;
        this.roster = new Student[seats];
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Student[] getRoster() {
        return this.roster;
    }

    public void setRoster(Student[] roster) {
        this.roster = roster;
    }

    /**
     * toString()
     * @return   returns a string containing the course name and credits
     */
    public String toString() {
        return (this.name + " " + this.credits);
    }

    /**
     * addStudent()
     * @param victim   a Student object to be added to the course's roster
     * @return     returns a boolean value of true if student was successfully added to roster
     */
    public boolean addStudent(Student victim) {
        // run through roster to check that the id of the student being added isn't already in the class
        for (Student drone : this.roster) {
            if (drone != null) {
                if (drone.getStudentID() == victim.getStudentID())
                    return false;
            }
        }

        // add student to roster if their is an available classroom seat
        if (seats > 0) {
            roster[--seats] = victim;         // pre decrement because zero indexed
            return true;
        }

        // no room to add student
        else
            return false;
    }

    /**
     * printRoster()
     * this method prints the roster of students to system.out
     */
    public void printRoster() {
        for (Student drone : this.roster) {
            if (drone != null) {
                System.out.println(drone.getName());
            }
        }
    }

    /**
     * averageGPA()
     * this method calculates the average of the students in the class GPAs
     * @return    returns a double of the average GPA of class members
     */
    public double averageGPA() {
        double gpa = 0.0;
        int count = 0;

        // sum the GPAs of students on the class roster and tally the number of students in the class
        for (Student drone : this.roster) {
            if (drone != null) {
                gpa += drone.getGPA();
                count++;
            }
        }

        // avoid divide by zero then return the average GPA
        if (count != 0)
           return (gpa/count);
        else
            return 0;
    }

    /**
     * MAIN *
     * @param args no arguments are expected
     */
    public static void main(String[] args) {
        // arrays of names to be used to generate student names
        String[] firstnames = {"Christopher", "Lauren", "Brett", "Robert", "Paul", "Tanya", "Robert", "Jenny", "Josh", "Brain", "William",
                "Vondale", "Melissa", "James", "Matthew", "Dianne", "Leanne", "Ryan", "Kemata", "Taylor", "Sean", "Alex", "Adrian",
                "Steven", "Ashley", "Phillip", "Karen", "Toshia", "Joseph", "Michael"};
        String[] lastnames = {"Bay", "Beck", "Borgstede", "Briggs", "Cook", "Couture", "Curran", "Fung", "Gallof", "Gregory", "Haas", "Harris",
                "Henry", "Kane", "Lamb", "Lee", "Lis", "Mahoney", "McCline", "Moody", "Murphy", "Myers", "Ossi", "Podgorski",
                "Schnepf", "Stoecker", "Sundfors", "Verheggen", "Warner", "Wheelock"};

        // create a course and place a random number of students with randomly paired first and last names in it
        Course Math666 = new Course("Math666 - Hellishly Difficult Proofs", 1, 50);
        int size = (int)(Math.random() * 51);
        for (int i = 0; i < size; i ++) {
            Student temp = new Student(firstnames[(int)(Math.random()*firstnames.length)],
                                       lastnames[(int)(Math.random()*lastnames.length)],
                                       (int)(Math.random()*900000)+100000);
            Math666.addStudent(temp);

            // add random GPA and credit hours to the student
            temp.setGPA(Math.random()*4.0);
            temp.setCredits((int)(Math.random() * 180));

            // assign a final grade  to students
            temp.submitGrade((int)(Math.random() * 4), Math666.getCredits());
        }

        // print the course name and roster
        System.out.println(Math666.getName());
        Math666.printRoster();
        System.out.println();



        // create another course and place a random number of students with randomly paired first and last names in it
        Course English005 = new Course("English005 - Mystery of the Semicolon Revealed", 4, 30);
        size = (int)(Math.random() * 31);
        for (int i = 0; i < size; i ++) {
            Student temp = new Student(firstnames[(int)(Math.random()*firstnames.length)],
                                       lastnames[(int)(Math.random()*lastnames.length)],
                                       (int)(Math.random()*900000)+100000);
            English005.addStudent(temp);
        }

        // print the course name and roster
        System.out.println(English005.getName());
        English005.printRoster();
        System.out.println();

        // create a legacy from two parents then print out all about them
        Student parent1 = new Student(firstnames[(int)(Math.random()*firstnames.length)],
                                      lastnames[(int)(Math.random()*lastnames.length)],
                                      (int)(Math.random()*900000)+100000);
        Student parent2 =  new Student(firstnames[(int)(Math.random()*firstnames.length)],
                                       lastnames[(int)(Math.random()*lastnames.length)],
                                       (int)(Math.random()*900000)+100000);
        // add random GPA and credit hours to the student
        parent1.setGPA(Math.random()*4.0);
        parent1.setCredits((int)(Math.random() * 180));
        parent2.setGPA(Math.random()*4.0);
        parent2.setCredits((int) (Math.random() * 180));
        // create the legacy
        Student legacy = parent1.createLegacy(parent2);

        // print parent1 info
        System.out.print(parent1.toString() + " ");
        System.out.print(parent1.getClassStanding() + " ");
        System.out.format("GPA %.3f ", parent1.getGPA());
        System.out.format("$%,d Tuition Paid\n", parent1.computeTuition());
        // print parent2 info
        System.out.print(parent2.toString() + " ");
        System.out.print(parent2.getClassStanding() + " ");
        System.out.format("GPA %.3f ", parent2.getGPA());
        System.out.format("$%,d Tuition Paid\n", parent2.computeTuition());
        // print legacy
        System.out.print(legacy.toString() + " ");
        System.out.print(legacy.getCredits() + " hours ");
        System.out.format("GPA %.3f ", legacy.getGPA());
    }
}

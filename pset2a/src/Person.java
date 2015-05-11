/**
 * Created by sean on 5/4/15.
 */
public class Person {
    private String name;
    private int IDnumber;

    /**
     * Constructor for Person object
     * @param fname     string containing first name to use for the person
     * @param lname     string containing last name to use for the person
     * @param IDnumber  integer number to brand the person as just another number
     */
    public Person(String fname, String lname, int IDnumber) {
        this.name = fname + " " + lname;
        this.IDnumber = IDnumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIDnumber() {
        return this.IDnumber;
    }

    public void setIDnumber(int IDnumber) {
        this.IDnumber = IDnumber;
    }
}

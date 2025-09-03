
/**
 * <h1>Student<h1>
 * <p>
 * 
 * </p>
*/
public class Student {
    private int    studentID;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private int    creditHours;
    private String house;

    Student(
        int newStudentID, String newFirstName, String newLastName, String newEmail,
        String newMajor, double newGpa, int newCreditHours, String newHouse) {
            this.studentID = newStudentID;
            this.firstName = newFirstName;
            this.lastName = newLastName;
            this.email = newEmail;
            this.major = newMajor;
            this.gpa = newGpa;
            this.creditHours = newCreditHours;
            this.house = newHouse;
    }

    public void setStudentID(int newStudentID) { this.studentID = newStudentID; }
    public int getStudentID() { return this.studentID; }

    public void setFirstName(String newFirstName)  { this.firstName = newFirstName; }
    public String getFirstName()  { return this.firstName; }

    public void setLastName(String newLastName) { this.lastName = newLastName; }
    public String getLastName() { return this.lastName; }

    public void setEmail(String newEmail) { this.email = newEmail; }
    public String getEmail() { return this.email;             }

    public void setMajor(String newMajor) { this.major = newMajor; }
    public String getMajor() { return this.major;             }

    public void setGpa(double newGpa) { this.gpa = newGpa; }
    public double getGpa() { return this.gpa; }

    public void setCreditHours(int newCreditHours) { this.creditHours = newCreditHours; }
    public int getCreditHours() { return this.creditHours; }

    public void setHouse(String newHouse) { this.house = newHouse; }
    public String getHouse() { return this.house; }
    
    @Override 
    public String toString() {
        return
            "\n\tStudent ID     "   + studentID +
            "\n\tFirst Name     "   + firstName +
            "\n\tLast Name      "   + lastName +
            "\n\tEmail          "   + email +
            "\n\tMajor          "   + major +
            "\n\tGPA            "   + gpa +
            "\n\tCredit Hours   "   + creditHours +
            "\n\tHouse          "   + house + 
            "\n";
    }

    int equals(){
        return 0;
    }

}

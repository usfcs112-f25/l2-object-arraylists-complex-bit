/**
 * <h2>Student</h2>
 * <p>
 * @brief Store a students information and display it.
 * @param studentID
 * @param firstName
 * @param lastName
 * @param email
 * @param major
 * @param gpa
 * @param creditHours
 * @param house
 * </p>
 * @author Eric T
 * @github complex-bit
 * @version 2 August 2025
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

    /**
     * <h3>setStudentID</h3>
     * <p>
     * @brief Sets the student ID.
     * @param newStudentID The instance student ID.
     * </p>
    */
    public void setStudentID(int newStudentID) { this.studentID = newStudentID; }

    /**
     * <h3>getStudentID</h3>
     * <p>
     * @brief Gets the student ID.
     * @return The StudentID. 
     * </p>
    */
    public int getStudentID() { return this.studentID; }

    /**
     * <h3>setFirstName</h3>
     * <p>
     * @brief Sets the first name.
     * @param newFirstName the instance first Name.
     * </p>
    */
    public void setFirstName(String newFirstName)  { this.firstName = newFirstName; }

    /**
     * <h3>getFirstName</h3>
     * <p>
     * @brief Gets the first name.
     * @return The first name. 
     * </p>
    */
    public String getFirstName()  { return this.firstName; }

    /**
     * <h3>setLastName</h3>
     * <p>
     * @brief Sets the last name.
     * @param newLastName the instance last Name.
     * </p>
    */
    public void setLastName(String newLastName) { this.lastName = newLastName; }

    /**
     * <h3>getLastName</h3>
     * <p>
     * @brief Gets the last name.
     * @return The last name. 
     * </p>
    */
    public String getLastName() { return this.lastName; }

    /**
     * <h3>setEmail</h3>
     * <p>
     * @brief Sets the email.
     * @param newEmail the instance email.
     * </p>
    */
    public void setEmail(String newEmail) { this.email = newEmail; }

    /**
     * <h3>getEmail</h3>
     * <p>
     * @brief Gets the email.
     * @return The email. 
     * </p>
    */
    public String getEmail() { return this.email; }

    /**
     * <h3>setMajor</h3>
     * <p>
     * @brief Sets the major.
     * @param newMajor the instance major.
     * </p>
    */
    public void setMajor(String newMajor) { this.major = newMajor; }

    /**
     * <h3>getMajor</h3>
     * <p>
     * @brief Gets the major.
     * @return The major. 
     * </p>
    */
    public String getMajor() { return this.major; }

    /**
     * <h3>setGpa</h3>
     * <p>
     * @brief Sets the GPA.
     * @param newGpa the instance GPA.
     * </p>
    */
    public void setGpa(double newGpa) { this.gpa = newGpa; }

    /**
     * <h3>getGpa</h3>
     * <p>
     * @brief Gets the gpa.
     * @return The gpa. 
     * </p>
    */
    public double getGpa() { return this.gpa; }

    /**
     * <h3>setCreditHours</h3>
     * <p>
     * @brief Sets the credit hours.
     * @param newCreditHours the instance credit hours.
     * </p>
    */
    public void setCreditHours(int newCreditHours) { this.creditHours = newCreditHours; }

    /**
     * <h3>getCreditHours</h3>
     * <p>
     * @brief Gets the credit hours.
     * @return The credit hours. 
     * </p>
    */
    public int getCreditHours() { return this.creditHours; }

    /**
     * <h3>setHouse</h3>
     * <p>
     * @brief Sets the house.
     * @param newHouse the instance house.
     * </p>
    */
    public void setHouse(String newHouse) { this.house = newHouse; }

    /**
     * <h3>getHouse</h3>
     * <p>
     * @brief Gets the house.
     * @return The house. 
     * </p>
    */
    public String getHouse() { return this.house; }

    /**
     * <h3>toString</h3>
     * <p>
     * @brief Format the information in a string.
     * @return The string to display. 
     * </p>
    */
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

    /**
     * <h3>equals</h3>
     * <p>
     * @brief Compare two students by student id.
     * @param studentA The first student to compare.
     * @param studentB The second student to compare.
     * @return The Student with the higher student id. 
     * </p>
    */
    public Student equals(Student studentA, Student studentB){
        return (studentA.getStudentID() > studentB.getStudentID()) ? studentA : studentB; 
    }
}
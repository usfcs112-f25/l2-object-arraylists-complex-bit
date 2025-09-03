// Assignment Requirements:
/* [ ] Student Class:
 [x] Student ID (integer)
 [x] First Name (string)
 [x] Last Name (string)
 [x] Email (string)
 [x] Major (string)
 [x] GPA (double)
 [x] Credit Hours (integer)
 [x] House (String)
 [x] Private instance variables for all data fields
 [x] A parameterized constructor that accepts all field values
 [x] Getter methods for all fields
 [x] A toString() method that returns a formatted string representation
 [ ] An equals() method that compares students by ID
*/
/* [ ] CSVProcessor Class:
    [ ] A method to read the CSV file and return an array of Student objects
    [x] Proper exception handling for file operations
    [ ] Input validation for data types and required fields
*/
/* [ ]StudentManager Class (Main Class):

    [x] This class contains the main method
    [] It reads in the file, processes it through the CSVProcessor, and displays a menu to demonstrates your program’s functionality
    [] Methods to display student information
    [] At least one method that performs analysis on the student data (e.g., calculate average GPA, count students by major)
    [] Technical Specifications
    [] File Processing Requirements
    [] Use Java’s built-in file reading capabilities (Scanner, BufferedReader, or similar)
    [] Parse CSV data manually (do not use external libraries)
    [] Handle the header row appropriately
    [] Validate data types during parsing
    [] Implement proper exception handling for malformed data
    [] Code Quality Requirements
    [] Follow Java naming conventions
    [] Include appropriate comments and JavaDoc documentation
    [] Use meaningful variable and method names
    [] Implement proper encapsulation principles
    [] Handle edge cases and invalid input gracefully
*/
// Specifications Grading:
/* [ ] Grade: C (70 points):
 [x] All required instance variables declared and properly encapsulated
 [x] Parameterized constructor that initializes all fields
 [x] Getter and Setter methods for all fields
 [x] toString() method returns student information in readable format
 [x] Program reads the provided CSV file
 [x] Creates Student objects from parsed data
 [x] Stores Student objects in an ArrayList
 [ ] Displays a menu that allows the user to:
    [] View all the students
    [] View all the students in a specific house
    [] Exit the program
*/
/* [] Grade: B (80 points)
 [] All the requirements for a C
 [] An improved Student Class
 [] equals() method implemented correctly
 [] toString() method provides well-formatted, professional output
 [] Input validation in constructor (e.g., non-negative GPA)
 [] Handle header row in the CSV correctly (skips or processes appropriately)
 [] Implement exception handling for file not found
 [] Validate data types during parsing (catches NumberFormatException)
 [] Add an option to the menu that displays the average GPA calculation for all the students in a user-specified house
 [] Add an option to the menu that writes out the average GPA for all the students to a file (gpa.txt)
 [] JavaDoc documentation for all public methods and classes
*/
/* [] Grade: A (90 points):
 [] All the requirements for a B
 [] Comprehensive exception handling for all file operations
 [] Graceful handling of malformed CSV data (bad formats, missing fields)
 [] Informative error messages that help identify problems
 [] Program continues processing valid data even when some rows are invalid
 [] Follows all Java naming conventions consistently
 [] Add an option to the menu that displays
 [] the number of students in each major
 [] the students in the Honor Roll (GPA > 3.5)
 [] Search functionality (find student by first name and display all their information)
 [] Write out the average GPA for all the students and the first and last names of all the students in the honor roll to a file (analysis.txt).
*/
/* [] Extra Credit:
 [] Display a sorted list based on the first name or the GPA (user's choice) - (2 points)
 [] Display all the students who have a GPA greater than a user specified value - (2 points)
*/
 [] Submission Requirements For All Grades:
 [] Accept the assignment by clicking on https://classroom.github.com/a/mCU4vxo6Links to an external site.Links to an external site.
 [] Submit your .java file(s)
 [] hogwarts.csv file used for testing
 [] README:
    [] Your name and Student ID
    [] Grade you are attempting (C/B/A grade)
    [] Explanation on how to run your program on the command line. Reminder: The CSV filename must be provided at the command line and not hard-coded in the Java file.
    [] AI Use
    [] hurdles you faced when working on the program
    [] Walk through video of your code and explain how the methods work in detail and demo your assignment.

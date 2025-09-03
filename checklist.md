# Checklist
## Assignment Requirements
### [ ] Student Class
- [x] Student ID (integer)\n
- [x] First Name (string)\n
- [x] Last Name (string)\n
- [x] Email (string)\n
- [x] Major (string)\n
- [x] GPA (double)\n
- [x] Credit Hours (integer)\n
- [x] House (String)\n
- [x] Private instance variables for all data fields\n
- [x] A parameterized constructor that accepts all field values\n
- [x] Getter methods for all fields\n
- [x] A toString() method that returns a formatted string representation\n
- [ ] An equals() method that compares students by ID\n

### [x] CSVProcessor Class
[x] A method to read the CSV file and return an array of Student objects
[x] Proper exception handling for file operations
[x] Input validation for data types and required fields

### [ ] StudentManager Class (Main Class)
[x] This class contains the main method
[x] It reads in the file, processes it through the CSVProcessor, and displays a menu to demonstrates your program’s functionality
[x] Methods to display student information
[x] At least one method that performs analysis on the student data (e.g., calculate average GPA, count students by major)
[] Technical Specifications
[x] File Processing Requirements
[x] Use Java’s built-in file reading capabilities (Scanner, BufferedReader, or similar)
[x] Parse CSV data manually (do not use external libraries)
[x] Handle the header row appropriately
[x] Validate data types during parsing
[x] Implement proper exception handling for malformed data
[x] Code Quality Requirements
[x] Follow Java naming conventions
[] Include appropriate comments and JavaDoc documentation
[x] Use meaningful variable and method names
[] Implement proper encapsulation principles
[x] Handle edge cases and invalid input gracefully

## Specifications Grading
### [x] Grade: C (70 points)
[x] All required instance variables declared and properly encapsulated
[x] Parameterized constructor that initializes all fields
[x] Getter and Setter methods for all fields
[x] toString() method returns student information in readable format
[x] Program reads the provided CSV file
[x] Creates Student objects from parsed data
[x] Stores Student objects in an ArrayList
[x] Displays a menu that allows the user to:
    [x] View all the students
    [x] View all the students in a specific house
    [x] Exit the program

### [] Grade: B (80 points)
[x] All the requirements for C
[] An improved Student Class
[] equals() method implemented correctly
[x] toString() method provides well-formatted, professional output
[] Input validation in constructor (e.g., non-negative GPA)
[x] Handle header row in the CSV correctly (skips or processes appropriately)
[] Implement exception handling for file not found
[x] Validate data types during parsing (catches NumberFormatException)
[x] Add an option to the menu that displays the average GPA calculation for all the students in a user-specified house
[x] Add an option to the menu that writes out the average GPA for all the students to a file (gpa.txt)
[] JavaDoc documentation for all public methods and classes

### [] Grade: A (90 points):
[] All the requirements for B
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

### [] Extra Credit:
[] Display a sorted list based on the first name or the GPA (user's choice) - (2 points)
[] Display all the students who have a GPA greater than a user specified value - (2 points)

## [] Submission Requirements For All Grades:
[x] Accept the assignment by clicking on https://classroom.github.com/a/mCU4vxo6Links to an external site.Links to an external site.
[] Submit your .java file(s)
[] hogwarts.csv file used for testing
[] README:
    [x] Your name and Student ID
    [x] Grade you are attempting (C/B/A grade)
    [x] Explanation on how to run your program on the command line. Reminder: The CSV filename must be provided at the command line and not hard-coded in the Java file.
    [] AI Use
    [] hurdles you faced when working on the program
    [] Walk through video of your code and explain how the methods work in detail and demo your assignment.

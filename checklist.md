# Checklist
## Assignment Requirements
- [x] Student Class
    - [x] Student ID (integer)
    - [x] First Name (string)
    - [x] Last Name (string)
    - [x] Email (string)
    - [x] Major (string)
    - [x] GPA (double)
    - [x] Credit Hours (integer)
    - [x] House (String)
    - [x] Private instance variables for all data fields
    - [x] A parameterized constructor that accepts all field values
    - [x] Getter methods for all fields
    - [x] A toString() method that returns a formatted string representation
    - [x] An equals() method that compares students by ID

- [x] CSVProcessor Class
    - [x] A method to read the CSV file and return an array of Student objects
    - [x] Proper exception handling for file operations
    - [x] Input validation for data types and required fields

- [x] StudentManager Class (Main Class)
    - [x] This class contains the main method
    - [x] It reads in the file, processes it through the CSVProcessor, and displays a menu to demonstrates your program’s functionality
    - [x] Methods to display student information
    - [x] At least one method that performs analysis on the student data (e.g., calculate average GPA, count students by major)
    - [x] Technical Specifications
    - [x] File Processing Requirements
    - [x] Use Java’s built-in file reading capabilities (Scanner, BufferedReader, or similar)
    - [x] Parse CSV data manually (do not use external libraries)
    - [x] Handle the header row appropriately
    - [x] Validate data types during parsing
    - [x] Implement proper exception handling for malformed data
    - [x] Code Quality Requirements
    - [x] Follow Java naming conventions
    - [x] Include appropriate comments and JavaDoc documentation
    - [x] Use meaningful variable and method names
    - [x] Implement proper encapsulation principles
    - [x] Handle edge cases and invalid input gracefully

## Specifications Grading
- [x] Grade: C (70 points)
    - [x] All required instance variables declared and properly encapsulated
    - [x] Parameterized constructor that initializes all fields
    - [x] Getter and Setter methods for all fields
    - [x] toString() method returns student information in readable format
    - [x] Program reads the provided CSV file
    - [x] Creates Student objects from parsed data
    - [x] Stores Student objects in an ArrayList
    - [x] Displays a menu that allows the user to:
        - [x] View all the students
        - [x] View all the students in a specific house
        - [x] Exit the program

- [x] Grade: B (80 points)
    - [x] All the requirements for C
    - [x] An improved Student Class
    - [x] equals() method implemented correctly
    - [x] toString() method provides well-formatted, professional output
    - [x] Input validation in constructor (e.g., non-negative GPA)
    - [x] Handle header row in the CSV correctly (skips or processes appropriately)
    - [x] Implement exception handling for file not found
    - [x] Validate data types during parsing (catches NumberFormatException)
    - [x] Add an option to the menu that displays the average GPA calculation for all the students in a user-specified house
    - [x] Add an option to the menu that writes out the average GPA for all the students to a file (gpa.txt)
    - [x] JavaDoc documentation for all public methods and classes

- [x] Grade: A (90 points):
    - [x] All the requirements for B
    - [x] Comprehensive exception handling for all file operations
    - [x] Graceful handling of malformed CSV data (bad formats, missing fields)
    - [x] Informative error messages that help identify problems
    - [x] Program continues processing valid data even when some rows are invalid
    - [x] Follows all Java naming conventions consistently
    - [x] Add an option to the menu that displays
        - [x] the number of students in each major
        - [x] the students in the Honor Roll (GPA > 3.5)
        - [x] Search functionality (find student by first name and display all their information)
        - [x] Write out the average GPA for all the students and the first and last names of all the students in the honor roll to a file (analysis.txt).

- [x] Extra Credit:
    - [x] Display a sorted list based on the first name or the GPA (user's choice) - (2 points)
    - [x] Display all the students who have a GPA greater than a user specified value - (2 points)

## Submission Requirements For All Grades:
- [x] Accept the assignment by clicking on https://classroom.github.com/a/mCU4vxo6Links to an external site.Links to an external site.
- [x] Submit your .java file(s)
- [x] hogwarts.csv file used for testing
- [x] README:
    - [x] Your name and Student ID
    - [x] Grade you are attempting (C/B/A grade)
    - [x] Explanation on how to run your program on the command line. Reminder: The CSV filename must be provided at the command line and not hard-coded in the Java file.
    - [x] AI Use
    - [x] hurdles you faced when working on the program
- [x] Walk through video of your code and explain how the methods work in detail and demo your assignment.

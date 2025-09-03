
// import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// import java.util.NoSuchElementException;
// import java.util.Hashtable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StudentManager {
    // TODO: change(FILE) -> args[0]
    private static final int ERROR = -1;
    private static final double HONORS_MIN = 3.5;
    private static final String FILE = "hogwarts-students.csv";
    private static final String KEYS[] = {"la", "lh", "ag", "sg", "lm", "ls", "sh", "ss", "xt"};
    private static CSVProcessor processor;
    private static ArrayList<Student> students;
    private static ArrayList<Student> honors; 
    private static Set<String> houses;
    private static double averageGpa = ERROR;



    // private static HashMap<String, HashMap<String, Integer>> houseStudents; // house, student_name, student_gpa
    
    /* Attempt1: 
    private static String getCommand() { // NOT WORKING AAH!
        // Scanner keyboard = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        String nextCommand = "";
        if (keyboard.hasNext()) {
            nextCommand = keyboard.next();
        } else {
            System.out.println("scanner no have next");
            keyboard.nextLine();
            keyboard.close();
            return getCommand();
        }
        // try {
        for (String command : commands) {
            System.out.println(command);
            if (command.equals(nextCommand)) {
                keyboard.nextLine();
                keyboard.close();
                return command;
            }
        }
        // } catch (NoSuchElementException nee) { System.out.println("Invalid command"); }
        keyboard.close();

        // If command was never found recurse:
        System.out.println("Command not found");
        return getCommand();
    }
    */
    /* Attempt2:
    private static String getCommand(Scanner scanner) {
        String command = "";
        if (scanner.hasNextLine()) {
            command = scanner.next();
            System.out.println(command + " `in getCommand`");
            //scanner.close();
            return command;
        }
        //scanner.close();
        return getCommand(scanner);
    }
    */
    /* Might not use:
    private static Hashtable<String, String> setupCommands() {
        String NAMES[] = {"allStudents", "houseStudents", "majorCount", "honorStudents", "exit"};
        String KEYS[] = {"va", "vh", "vm", "vs", "x"};
        if (NAMES.length != KEYS.length) {
            System.out.println("ERROR: " + NAMES.length + " != " + KEYS.length + " exiting");
            System.exit(1);
        }
        for (int i = 0; i < KEYS.length; i++) {
            commands.put(NAMES[i], KEYS[i]);
        }
        return commands;
    }
    */

    private static String getCommand(Scanner scanner) {
        System.out.print("\t> ");
        String nextCommand = scanner.next();
        for (String key : KEYS) {
            if (nextCommand.equals(key)) {
                return key;
            }
        }
     
        System.out.println("\tInvalid command: " + nextCommand);
        return getCommand(scanner);
    }    

    private static void displayAllStudents() {
        for (Student student : students) {
            System.out.printf("\t%s %s\n", student.getFirstName(), student.getLastName());
        }
    }

    private static void findHouses() {
        houses = new HashSet<>();
        Set<String> knownHouseSet = new HashSet<>(Arrays.asList(processor.getKnownHouses()));
        for (Student student : students) {
            houses.add(student.getHouse());
        }
        // Only keep known houses:
        houses.retainAll(knownHouseSet);
    }

    private static void findHonors() {
        honors = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getGpa() > HONORS_MIN) {
                honors.add(student);
            }
        }
    }

    /* Attempt 1 -> too complicated:
    private static void displayStudentsByHouse() {
        // Only find houses if not yet found: (no longer needed)
        // if (houses == null || houses.size() != KOWN_HOUSES.length) { findHouses(); }
        System.out.println("\t" + houses);
        houseStudents = new HashMap<String, HashMap<String, Integer>>();
        for (Student student : students) {
            if (houses.contains(student.getHouse())) {
                houseStudents.get(student.getHouse()) = 
            }
            for (String house : houses) {
                if (student.getHouse().equals(house)) {
                    houseStudents.put(house, student.getFirstName() + " " + student.getLastName());
                }
            }
            // houseStudents.put(house, );
        }
        // System.out.println(houseStudents);

        for (String house : houseStudents.keySet()) {
            System.out.println("Students in " + house + ":");
            System.out.println(houseStudents.get(house));
        }
    }
    */

    /**
     * <h3> queryHouse <h3>
     * @brief used whenever we need to get a house choice from the user.
    */
    private static String queryHouse(Scanner scanner) {
        System.out.print("\n\tEnter house > ");
        String inputHouse = scanner.next();
        if (houses.contains(inputHouse)) { 
            return inputHouse;
        }
        System.out.println(
            "\n\tInvalid house '" + inputHouse + "', please enter a valid house." +
            "\n\tValid houses: " + houses
        );
        // Retry for a valid house: 
        return queryHouse(scanner);
    }

    private static void displayStudentsByHouse(Scanner scanner) {
        String house = queryHouse(scanner);
        System.out.printf("\n\tStudents in %s:\n", house);
        for (Student student : students) {
            if (student.getHouse().equals(house)) {
                System.out.printf("\t%s %s\n", student.getFirstName(), student.getLastName());
            }
        }
    }

    private static void displayHouseGPA(Scanner scanner) {
        String house = queryHouse(scanner);
        double sum = 0;
        int count = 0;
        double average;
        if (students.isEmpty()) {
            // Student class should not be empty:
            System.out.println("ERROR: student class is empty");
            return;
        }
        for (Student student : students) {
            if (student.getHouse().equals(house)) {
                sum += student.getGpa();
                count++;
            }
        }
        // might not need this try block:
        try {
            average = sum / count;
            System.out.printf("\n\tThe average GPA in %s is %.2f\n", house, average);
        } catch (NumberFormatException zeroDivision) {
            System.out.println("ERROR: Division by zero.");
            return;
        }   
    }

    private static void calculateAverageGpa() {
        int sum = 0;
        int count = 0;
        for (Student student : students) {
            // Ensure average does not include -1:
            if (student.getGpa() != ERROR) {
                sum += student.getGpa();
                count++;
            }
        }
        averageGpa = sum / count;
    }

    private static void saveGpa() {
        final String FILENAME = "gpa.txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
            bw.write("" + averageGpa);
            bw.close();
            System.out.printf("\tSaved avergage gpa of %.2f to file: %s\n", averageGpa, FILENAME);

        } catch (IOException ioe) {
            System.out.printf("ERROR: Failed to save %.2f to %s", averageGpa, FILENAME);
        }
    }

    private static void displayMajorCount() {
        HashMap<String, Integer> majorCount = new HashMap<>();
        int longestMajor = 0;
        for (Student student : students) {
            String current = student.getMajor();
            longestMajor = (current.length() > longestMajor) ? current.length() : longestMajor;
            if (majorCount.containsKey(current)) {
                majorCount.put(current, majorCount.get(current) + 1);
            } else {
                majorCount.put(current, 1);
            }
        }
        for (int i = 0; i < majorCount.size(); i++) {
            String major = (String)majorCount.keySet().toArray()[i];
            System.out.printf("\t%s ", major);
            // Even spacing between major name and count:
            for (int j = 0; j <= longestMajor - major.length(); j++) {
                System.out.print(".");    
            }
            System.out.printf(" %d\n", majorCount.get(major));
        }
    }

    private static void displayHonorsStudents() {
        System.out.printf("\n\tHonors students (GPA > %.2f):\n", HONORS_MIN);
        if (honors.isEmpty()) {
            System.out.println("Honors list is empty");
            return;
        }
        for (Student student : honors) {
            System.out.printf("\t%s %s\n", student.getFirstName(), student.getLastName());
        }
    }

    private static void saveHonors() {
        final String FILENAME = "analysis.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
            writer.write(
                "Average GPA of all Students: " + averageGpa + "\n" + 
                "\nHonors roll (GPA > " + HONORS_MIN + "):\n"
            );
            for (Student student : honors) {
                writer.write(student.getFirstName() + " " + student.getLastName() + "\n");
            }
            writer.close();
        } catch (IOException ioe) {
            System.out.printf("ERROR: Failed to save stats to %s", FILENAME);
        }
    }

    private static void search(Scanner scanner) {
        System.out.printf("\tEnter first name (enter %s to quit) > ", KEYS[8]);
        String query = scanner.next();

        if (query.equals(KEYS[8])) {
            return;
        }

        for (Student student : students) {
            if (query.equals(student.getFirstName())) {
                System.out.println(student);
                return;
            }
        }
        System.out.printf("\t'%s' not found, trying again...\n", query);
        search(scanner);
    }

    private static void runMenu(Scanner scanner) {
        System.out.printf(
            "\n\tMENU:\n" +
              "\tList all students ......................... %s\n" +
              "\tList Students by house .................... %s\n" + 
              "\tShow average GPA of house ................. %s\n" + 
              "\tSave average GPA of all students .......... %s\n" + 
              "\tNumber of students in each major .......... %s\n" + 
              "\tList students in honors ................... %s\n" +
              "\tSave students in honors and average GPA ... %s\n" +
              "\tSearch for student ........................ %s\n" +
              "\tExit ...................................... %s\n\n",
               KEYS[0], KEYS[1], KEYS[2], KEYS[3], KEYS[4], KEYS[5], 
               KEYS[6], KEYS[7], KEYS[8]
        );

        String command = getCommand(scanner); 

        if (command.equals(KEYS[0])) { displayAllStudents();            }
        if (command.equals(KEYS[1])) { displayStudentsByHouse(scanner); }
        if (command.equals(KEYS[2])) { displayHouseGPA(scanner);        }
        if (command.equals(KEYS[3])) { saveGpa();                       }
        if (command.equals(KEYS[4])) { displayMajorCount();             }
        if (command.equals(KEYS[5])) { displayHonorsStudents();         }
        if (command.equals(KEYS[6])) { saveHonors();                    }
        if (command.equals(KEYS[7])) { search(scanner);                 }
        if (command.equals(KEYS[8])) { return;                          }
        runMenu(scanner);
    }

    /** 
     * @param args Not being used for now.
    */
    public static void main(String[] args) {
        // TODO: maybe make house class and fill with student objects at the beginning of program.
        processor = new CSVProcessor(FILE);
        students = processor.readCSV();
        Scanner scanner = new Scanner(System.in);

        // Call these functions before the menu to set up lists:
        calculateAverageGpa();
        findHouses();
        findHonors();
        runMenu(scanner);
        scanner.close();
    }
}

/* Questions:
 * Github assignment repo commits?
 * Should save options be in main menu or follow other commands?
 * Save all gpa of house or all students?
 * Is there a better way to store the constants?
 * Can key commands and coresponding functions be stored in hash map?
 * If going for A do we need gpa.txt and analysis.txt
 * Should filenames for output files be input by user? 
 * if error occurs when parsing number in processor print message or fail silently?
 * Extra credit sorted list of what? all students?
 * Coding faster
*/


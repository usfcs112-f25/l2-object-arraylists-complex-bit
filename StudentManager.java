import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>StudentManager</h1>
 * <h4>Main class for lab</h4>
 * <p>
 * @brief Runs a menu displaying Hogwarts information.
 * <p>
 * @author Eric T
 * @github complex-bit
 * @version 2 August 2025 
*/
public class StudentManager {
    private static final int ERROR = -1;
    private static final double HONORS_MIN = 3.5;
    private static double averageGpa = ERROR;
    private static ArrayList<Student> students;
    private static ArrayList<Student> honors; 
    private static CSVProcessor processor;
    private static Set<String> houses;
    private static String command;
    private static final String KEYS[] = {
        "la", "lh", "ag", "sg", "lm", "ls", "sv", "sh", "so", "hg", "ex"
    };

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
            System.out.println("ERROR: student class is empty");
            return;
        }
        for (Student student : students) {
            if (student.getHouse().equals(house)) {
                sum += student.getGpa();
                count++;
            }
        }
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
            // Ensure average does not include the error value:
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

    private static void sortStudents(Scanner scanner) {
        ArrayList<String> commands = new ArrayList<String>(Arrays.asList("name", "gpa", "ex"));
        ArrayList<Student> sortedStudents = students;
        System.out.printf("\tEnter 'name', 'gpa' or 'ex' to exit >");
        String command = scanner.next();
        if (!commands.contains(command)) {
            System.out.printf("\t%s not in :", command);
            System.out.print(commands);
            sortStudents(scanner);
        }
        if (command.equals(commands.get(0))) {
            sortedStudents.sort(Comparator.comparing(Student::getFirstName));
        }
        if (command.equals(commands.get(1))) {
            sortedStudents.sort(Comparator.comparing(Student::getGpa));
        }
        if (command.equals(commands.get(2))) {
            return;
        }
        for (Student student : students) {
            System.out.printf("%s %s\n", student.getFirstName(), student.getLastName());
        }
        sortStudents(scanner);
    }

    private static void listGpaAbove(Scanner scanner) {
        double gpa;
        try {
            System.out.print("Enter GPA > ");
            gpa = Double.parseDouble(scanner.next());
            if (gpa > 4.0 || gpa < 0.0) { 
                System.out.println("Invalid gpa");
                listGpaAbove(scanner);
            }
            for (Student student : students) {
                if (student.getGpa() > gpa) {
                    System.out.printf("s% s%", student.getFirstName(), student.getLastName());
                }
            }
            
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid gpa");
            return;
        }
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
              "\tSort students by first name or GPA ........ %s\n" +
              "\tList students with higeher GPA ............ %s\n" +
              "\tExit ...................................... %s\n\n",
               KEYS[0], KEYS[1], KEYS[2], KEYS[3], KEYS[4], KEYS[5], 
               KEYS[6], KEYS[7], KEYS[8], KEYS[9], KEYS[10]
        );
        command = getCommand(scanner); 
        if (command.equals(KEYS[0]))  { displayAllStudents();            }
        if (command.equals(KEYS[1]))  { displayStudentsByHouse(scanner); }
        if (command.equals(KEYS[2]))  { displayHouseGPA(scanner);        }
        if (command.equals(KEYS[3]))  { saveGpa();                       }
        if (command.equals(KEYS[4]))  { displayMajorCount();             }
        if (command.equals(KEYS[5]))  { displayHonorsStudents();         }
        if (command.equals(KEYS[6]))  { saveHonors();                    }
        if (command.equals(KEYS[7]))  { search(scanner);                 }
        if (command.equals(KEYS[8]))  { sortStudents(scanner);           }
        if (command.equals(KEYS[9]))  { listGpaAbove(scanner);           }
        if (command.equals(KEYS[10])) { return;                          }
        runMenu(scanner);
    }

    /** 
     * <h3>main</h3>
     * @brief Sets up needed information before displaying a menu.
     * @param args The filename is povided as `args[0]`.
    */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("ERROR: No filename provided");
            return;
        }
        // Processor handles file errors:
        processor = new CSVProcessor(args[0]);
        students = processor.readCsv();
        Scanner scanner = new Scanner(System.in);

        // Call these functions before the menu to set up lists:
        calculateAverageGpa();
        findHouses();
        findHonors();
        runMenu(scanner);
        scanner.close();
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * <h2>CSVProcessor<h2>
 * <p>
 * @brief
 * A reads the CSV file, validate fields and return an array of Student objects.
 * @param instanceFilename The filename provided by `StudentManager`.
 * <p/>
 * @author Eric T
 * @github complex-bit
 * @version 2 August 2025
*/
public class CSVProcessor {
    private static final int ZERO  =  0;
    private static final int ONE   =  1;
    private static final int TWO   =  2;
    private static final int THREE =  3;
    private static final int FOUR  =  4;
    private static final int FIVE  =  5;
    private static final int SIX   =  6;
    private static final int SEVEN =  7;
    private static final int ERROR = -1;
    private static final String NONE = "NONE";
    private static final int ID_LENGTH = FOUR;
    private static final String[] KNOWN_HOUSES = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    private String file;

    CSVProcessor(String instanceFilename) {
        file = instanceFilename;
    }

    /**
     * <h3>getKnownHouses</h3>
     * <p>
     * @brief Gets the known houses.
     * </p>
     * @return The known houses. 
    */
    public String[] getKnownHouses() {
        return KNOWN_HOUSES;
    }

    private static LinkedList<String> split(String line) {
        LinkedList<String> fields = new LinkedList<String>();
        String field = "";
        for (int i = ZERO; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                fields.add(field);
                field = "";
            } 
            else {
                field += line.charAt(i);
            }
        }
        fields.add(field);
        return fields;
    }

    private static boolean alphanumeric(char character) {
        return character >= '0' && character <= '9';
    }

    private static boolean alphabetic(char character) {
        return (character >= 'a' && character <= 'z') || uppercase(character);
    }
    
    private static boolean uppercase(char character) {
        return (character >= 'A' && character <= 'Z');
    }

    private static char convertCase(char letter) {
        final int ADDEND = 32;
        if (!alphabetic(letter)) {
            System.out.printf("ERROR: skipped '%c', because is not alphabetic\n", letter);
            return letter;
        }
        if (uppercase(letter)) {
            // ASCII uppercase to lowercase:
            return (char)((int)letter + ADDEND);
        }
        // ASCII lowercase to uppercase:
        return (char)((int)letter - ADDEND);
    }
    
    private static int convertInteger(String characters) {
        try {
            return Integer.parseInt(characters);
        } catch (NumberFormatException nfe) {
            return ERROR;
        }
    }

    private static double convertDouble(String characters) {
        try {
            return Double.parseDouble(characters);
        } catch (NumberFormatException nfe ) {
            return ERROR;
        }
    }
    
    private static int validId(String idIn) {
        int idOut = convertInteger(idIn);
        // Validate ID length:
        if ((int)Math.log10(idOut) + ONE != ID_LENGTH) {
            return ERROR;
        }

        return idOut;
    }

    private static String validName(String name) {
        String formatedName = "";

        // Ensure first character of name is upper case:
        if (!uppercase(name.charAt(ZERO))) {
            formatedName += convertCase(name.charAt(ZERO));
        } else {
            formatedName += name.charAt(ZERO);
        }
        // Loop skips first character:
        for (int i = 1; i < name.length(); i++) {
            if (!alphabetic(name.charAt(i))) {
                return NONE;
            }
            formatedName += name.charAt(i);
        }
        return formatedName;
    }

    private static String validEmail(String email) {
        final char AT = '@';
        final char DOT = '.';
        int atCount = ZERO;
        int dotCount = ZERO;
        String cleanEmail = "";

        for (int i = ZERO; i < email.length(); i++) {
            char current = email.charAt(i);
            // check if dot precedes at:
            if (atCount == ZERO && dotCount != ZERO) {
                return NONE;
            }
            
            if (current == AT) {
                atCount++;
            }
            if (current == DOT) {
                dotCount++;
            }
            if (alphabetic(current) || alphanumeric(current) ||
                current == AT || current == DOT) {
                    cleanEmail += current;
            }
        }
        
        if (!(atCount == ONE && dotCount == ONE)) {
            return NONE;
        }
        return cleanEmail;
    }    
    
    private static String validMajor(String major) {
        final char MOD = '&';
        final char SPACE = ' ';
        for (int i = ZERO; i < major.length(); i++) {
            char current = major.charAt(i);
            if (!(alphabetic(current) || current == MOD || current == SPACE)) {
                return NONE;
            }
        }
        return major;
    }

    private static double validGpa(String gpa) {
        double cleanGpa = convertDouble(gpa);
        if (cleanGpa >= (double)ZERO && cleanGpa <= (double)FOUR) {
            return cleanGpa;
        }
        return ERROR;
    }

    private static int validCredit(String hours) {
        return convertInteger(hours);
    }

    private static String validHouse(String house) {
        for (int i = 0; i < KNOWN_HOUSES.length; i++) {
            if (KNOWN_HOUSES[i].equals(validName(house))) {
                return KNOWN_HOUSES[i];
            }
        }
        return NONE;
    }
    
    /**
     * <h3>readCsv<h3>
     * @brief Reads the CSV file and validates each field.
     * @return An array of Student objects.
    */
    public ArrayList<Student> readCsv() {    
        ArrayList<Student> students = new ArrayList<Student>();
        BufferedReader bufferIn;
        try { 
            bufferIn = new BufferedReader(new FileReader(file));
            String line = bufferIn.readLine();
            while ((line = bufferIn.readLine()) != null) {
                LinkedList<String> fields = split(line);
                Student student = new Student(
                    validId(fields.get(ZERO)), 
                    validName(fields.get(ONE)),
                    validName(fields.get(TWO)),
                    validEmail(fields.get(THREE)),
                    validMajor(fields.get(FOUR)),
                    validGpa(fields.get(FIVE)),
                    validCredit(fields.get(SIX)),
                    validHouse(fields.get(SEVEN))
                );                
                students.add(student);
            }
            bufferIn.close();
        } catch(IOException ioe) { 
            System.out.println("Invalid Filename: " + file);
            System.exit(ERROR);
        }
        return students;
    }
}
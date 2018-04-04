/**
* Program
*/

import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.util.InputMismatchException;

/**
 * The main class of the project that contains the main method. To run the project, run this class
 *
 * @see Student
 */
public class Program {

    /**
     * The main method that is the entry-point at runtime
     *
     * @param args The arguments can be passed to the program
    */
    public static void main(String[] args){

        // This is the list of all students currently loaded into the program
        List<Student> students = new ArrayList<Student>();

        // Scanner to get the user's input
        Scanner in = new Scanner(System.in);

        // Store the user's input
        int choice;

        // True whilst the user wants the program to continue running
        boolean running = true;
        while (running){
            // Display all of the menu options
            System.out.println("");
            System.out.println("Please select an option:");
            System.out.println("\t1. Load student data from file");
            System.out.println("\t2. Save student data to file");
            System.out.println("\t3. Add a student");
            System.out.println("\t4. View students");
            System.out.println("\t5. Delete a student by index");
            System.out.println("\t6. Quit");
            System.out.println("");
            // If the user has entered an int
            if (in.hasNextInt()){
                // Get the int
                choice = in.nextInt();
                // If it is not a valid menu choice
                if (choice >= 9 || choice <= 0){
                    System.out.println("Please enter a valid input");
                } else {
                    // Therefore a valid menu choice so get which choice it was and call the appropriate method
                    switch (choice) {
                        case 1:
                        students = optionLoad();
                        break;
                        case 2:
                        optionSave(students);
                        break;
                        case 3:
                        students.add(optionAdd());
                        break;
                        case 4:
                        filterMenu(students);
                        break;
                        case 5:
                        students = optionDelete(students);
                        break;
                        case 6:
                        running = false;
                        break;
                        default:
                        break;
                    }
                }
            } else {
                // Else the user hasn't entered an int
                System.out.println("Please enter a valid input");
                in.next();
            }
        }
    }

    /**
     * Displays the menu that shows all of the options for displaying students
     *
     * @param students List of all students. Doesn't use parent's list of students for explicitness so the method can be easily reused
     */
    public static void filterMenu(List<Student> students) {
         // Get the user's choice
        Scanner in = new Scanner(System.in);
        System.out.println("Please select an option:");
        System.out.println("\t1. View all students");
        System.out.println("\t2. Filter by address");
        System.out.println("\t3. Filter by course");

        // Standard validaiton
        int choice;
        while (true) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                System.out.println("Got int");
                if (choice != 1 && choice != 2 && choice != 3) {
                    System.out.println("Please enter a valid option");
                } else {
                    break;
                }
            } else {
                System.out.println("Please enter a valid option");
                in.next();
            }
        }

        // Act appropriately based off of the input
        if (choice == 1) {
            optionShow(students);
        } else if (choice == 2) {
            optionSearchAddresses(students);
        } else if (choice == 3) {
            optionSearchCourse(students);
        }
    }

    /**
     * Saves the students to a file
     *
     * @param binary Whether the user wants to save as plaintext or binary
     * @param path The path to the file the user wants to save to. If the file doesn't exist, then a new *empty* one will be created
     * @param students The list of students to save
     *
     * @throws IOException
    */
    public static void save(boolean binary, String path, List<Student> students) throws IOException {
        if (binary){
            // Class ObjectOutputStream retrieved 04/04/18
            // https://docs.oracle.com/javase/9/docs/api/java/io/ObjectOutputStream.html
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            // Serialize object. Very similar to python pickle
            out.writeObject(students);
            out.close();
        }
        else {
            // Save each student as a new line in a .tsv style file
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            for (Student student : students) {
                writer.println(student.getName() + "\t" + student.getNumber() + "\t" + student.getCourse() + "\t" + student.getId() + "\t" + student.getHouseNumber() + "\t" + student.getStreetName() + "\t" + student.getTown() + "\t" + student.getPostcode());
            }
            writer.close();
        }
    }

    /**
     * Load students' details from a file
     *
     * @param binary Whether the file loaded is binary or text
     * @param path The path of the file to load
     *
     * @throws IOException
     * @throws ClassNotFoundException Thrown when the student class loaded doesn't match the actual student class
     */
    public static List<Student> load(boolean binary, String path) throws IOException, ClassNotFoundException {
        // TODO: Add error checking & text load
        if (binary){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            List<Student> s = (List<Student>) in.readObject();
            in.close();
            return s;
        } else {
            List<Student> students = new ArrayList<Student>();
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                List<String> values = new ArrayList<String>(Arrays.asList(line.split("\t")));
                students.add(new Student(values.get(0), values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7)));
            }
            return students;
        }
    }

    public static List<Student> optionLoad() {
        // Repeatedly try until a valid file is loaded
        // TODO: Some sort of way to escape `while` loop instead of loading a file
        while (true){
            System.out.println("Please enter the path/filename that you wish to load:");
            Scanner in = new Scanner(System.in);
            String path = in.nextLine();
            System.out.println("Is this:\n\t1. A binary file\n\t2. A text file?");
            int choice;
            while (true) {
                if (in.hasNextInt()) {
                    choice = in.nextInt();
                    if (choice >= 3 || choice <= 0) {
                        System.out.println("Please enter a valid number");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Please enter a valid number");
                    in.next();
                }
            }
            try{
                if (choice == 1){
                    return load(true, path);
                } else {
                    return load(false, path);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Unable to load file\n");
            }
        }
    }

    public static void optionSave(List<Student> students) {
        while (true) {
            System.out.println("Please enter the path/filename that you wish to save:");
            Scanner in = new Scanner(System.in);
            String path = in.nextLine();
            System.out.println("Would you like to save as:\n\t1. A binary file\n\t2. A text file?");
            int choice;
            while (true) {
                if (in.hasNextInt()) {
                    choice = in.nextInt();
                    if (choice >= 3 || choice <= 0) {
                        System.out.println("Please enter a valid number");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Please enter a valid number");
                    in.next();
                }
            }
            try {
                if (choice == 1) {
                    save(true, path, students);
                    return;
                } else {
                    save(false, path, students);
                    return;
                }
            } catch (IOException e) {
                System.out.println("Unable to save file\n");
            }
        }
    }

    public static Student optionAdd() {
        String name;
        String number;
        String course;
        String id;
        String houseNumber;
        String streetName;
        String town;
        String postcode;
        Scanner in = new Scanner(System.in);
        Student student = new Student();

        while (true) {
            try {
                System.out.println("Please enter the student's name:");
                name = in.nextLine();
                student.setName(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Please enter the student's number:");
                number = in.nextLine();
                student.setNumber(number);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Please enter the student's course name:");
                course = in.nextLine();
                student.setCourse(course);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Please enter the student's course ID:");
                id = in.nextLine();
                student.setId(id);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Please enter the student's house number:");
                houseNumber = in.nextLine();
                student.setHouseNumber(houseNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        while (true) {
            try {
                System.out.println("Please enter the student's street name:");
                streetName = in.nextLine();
                student.setStreetName(streetName);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Please enter the student's town:");
                town = in.nextLine();
                student.setTown(town);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("Please enter the student's postcode:");
                postcode = in.nextLine();
                student.setPostcode(postcode);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return student;
    }

    public static void display(List<Student> students) {
        System.out.println("-----------------------------------");
        for (Student student : students) {
            System.out.println("Name:        " + student.getName());
            System.out.println("Student No.: " + student.getNumber());
            System.out.println("Course Name: " + student.getCourse());
            System.out.println("Course ID:   " + student.getId());
            System.out.println("House No.:   " + student.getHouseNumber());
            System.out.println("Street Name: " + student.getStreetName());
            System.out.println("Town:        " + student.getTown());
            System.out.println("Postcode:    " + student.getPostcode());
            System.out.println("-----------------------------------");
        }
    }

    public static void optionShow(List<Student> students) {
        Scanner in = new Scanner(System.in);
        if (students.size() > 0){
            System.out.println("Would you like to view:");
            System.out.println("\t1. All of the relevant students");
            System.out.println("\t2. A subset of the relevant students");
            int choice;
            while (true) {
                if (in.hasNextInt()) {
                    choice = in.nextInt();
                    System.out.println("Got int");
                    if (choice != 1 && choice != 2) {
                        System.out.println("Please enter a valid option");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Please enter a valid option");
                    in.next();
                }
            }
            if (choice == 1) {
                display(students);
            } else {
                System.out.println("There are " + Integer.toString(students.size()) + " relevant students");
                System.out.println("Please enter starting student index (1 - " + Integer.toString(students.size()) + ")");
                int startIndex;
                while (true) {
                    if (in.hasNextInt()) {
                        startIndex = in.nextInt();
                        if (startIndex > students.size() || startIndex < 1) {
                            System.out.println("Please enter a valid option");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Please enter a valid option");
                        in.next();
                    }
                }

                System.out.println("Please enter ending student index (" + Integer.toString(startIndex) + " - " + Integer.toString(students.size()) + ")");
                int endIndex;
                while (true) {
                    if (in.hasNextInt()) {
                        endIndex = in.nextInt();
                        if (endIndex < startIndex || endIndex > students.size()) {
                            System.out.println("Please enter a valid option");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Please enter a valid option");
                        in.next();
                    }
                }

                display(students.subList(startIndex - 1, endIndex));
            }
        } else {
            System.out.println("There are no students to display");
        }
    }

    public static void optionSearchCourse(List<Student> students) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a substring to search courses for:");
        String subString = in.nextLine();
        List<Student> matches = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getCourse().toLowerCase().contains(subString.toLowerCase())) {
                matches.add(student);
            }
        }
        optionShow(matches);
    }

    public static void optionSearchAddresses(List<Student> students) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a substring to search address for:");
        String subString = in.nextLine();
        List<Student> matches = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getHouseNumber().toLowerCase().contains(subString.toLowerCase()) ||
                student.getStreetName().toLowerCase().contains(subString.toLowerCase()) ||
                student.getTown().toLowerCase().contains(subString.toLowerCase()) ||
                student.getPostcode().toLowerCase().contains(subString.toLowerCase())) {
                matches.add(student);
            }
        }
        optionShow(matches);
    }

    public static List<Student> optionDelete(List<Student> students) {
        System.out.println("Please enter the index of the student you wish to delete:");
        Scanner in = new Scanner(System.in);
        int choice;
        while (true) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                try {
                    students.remove(choice - 1);
                    System.out.println("Deleted student " + Integer.toString(choice));
                    break;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("This index doesn't exist");
                }
            } else {
                System.out.println("Please enter a valid option");
                in.next();
            }
        }
        return students;
    }
}

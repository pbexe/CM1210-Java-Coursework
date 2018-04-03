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

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        List<Student> students = new ArrayList<Student>();
        Scanner in = new Scanner(System.in);
        int choice;
        boolean running = true;
        while (running){
            System.out.println("");
            System.out.println("Please select an option:");
            System.out.println("\t1. Load student data from file");
            System.out.println("\t2. Save student data to file");
            System.out.println("\t3. Add a student");
            System.out.println("\t4. Display all students");
            System.out.println("\t5. Search students by course");
            System.out.println("\t6. Search student addresses");
            System.out.println("\t7. Display subset of students");
            System.out.println("\t8. Quit");
            System.out.println("");
            if (in.hasNextInt()){
                choice = in.nextInt();
                if (choice >= 9 || choice <= 0){
                    System.out.println("Please enter a valid input");
                } else {
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
                        optionShowAll(students);
                        break;
                        case 5:
                        optionSearchCourse(students);
                        break;
                        case 6:
                        break;
                        case 7:
                        break;
                        case 8:
                        running = false;
                        break;
                        default:
                        break;
                    }
                }
            } else {
                System.out.println("Please enter a valid input");
                in.next();
            }
        }
    }

    public static void save(boolean binary, String path, List<Student> students) throws IOException {
        if (binary){
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(students);
            out.close();
        }
        else {
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            for (Student student : students) {
                writer.println(student.getName() + "\t" + student.getNumber() + "\t" + student.getCourse() + "\t" + student.getId() + "\t" + student.getHouseNumber() + "\t" + student.getStreetName() + "\t" + student.getTown() + "\t" + student.getPostcode());
            }
            writer.close();
        }
    }

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

    public static void optionShowAll(List<Student> students) {
        if (students.size() > 0){
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
        optionShowAll(matches);
    }
}

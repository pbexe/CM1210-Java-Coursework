/**
* Program
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.lang.ClassNotFoundException;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        List<Student> students = new ArrayList<Student>();
            Scanner in = new Scanner(System.in);
            int choice;
            while (true){
                System.out.println("Please select an option:");
                System.out.println("\t1. Load student data from file");
                System.out.println("\t2. Save student data to file");
                System.out.println("\t3. Add a student");
                System.out.println("\t4. Display all students");
                System.out.println("\t5. Search students by course");
                System.out.println("\t6. Search student addresses");
                System.out.println("\t7. Display subset of students");
                System.out.println("\t8. Quit");
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
            try{
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static List<Student> load(boolean binary, String path) throws IOException, ClassNotFoundException{
            // TODO: Add error checking
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            List<Student> s = (List<Student>) in.readObject();
            in.close();
            return s;
        }

        public static List<Student> optionLoad() throws IOException{
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
    }
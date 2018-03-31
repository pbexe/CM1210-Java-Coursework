/**
 * Program
 */

import java.util.ArrayList;
import java.util.List;

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
        Student s = new Student("Bob bobby", "C123456", "CompSci", "CM1234", "11a", "Bobby st", "A town", "CF1CF");
        students.add(s);
        Student t = new Student("Miles Budden", "C234567", "CompSci", "CM1202", "11b", "Birchwood Road", "Cardiff", "CF2CF");
        students.add(t);
        save(true, "file.dat", students);
        List<Student> x = load(true, "file.dat");
        for (Student student : x) {
            System.out.println(student.getName());
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
}
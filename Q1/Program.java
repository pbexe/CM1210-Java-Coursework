/**
 * Program
 */

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Program {

    public static void main(String[] args) throws IOException{
        System.out.println("Hello");
        List<Student> students = new ArrayList<Student>();
        Student s = new Student("Bob bobby", "C123456", "CompSci", "CM1234", "11a", "Bobby st", "A town", "CF1CF");
        students.add(s);
        Student t = new Student("Miles Budden", "C234567", "CompSci", "CM1202", "11b", "Birchwood Road", "Cardiff", "CF2CF");
        students.add(t);
        save(true, "file.tsv", students);
    }

    public static void save(boolean binary, String path, List<Student> students) throws IOException {
        if (binary){
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.dat"));
            out.writeObject(students);
            out.close();
            // throw new UnsupportedOperationException("Haven't done this yet");
        }
        else {
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            for (Student student : students) {
                writer.println(student.getName() + "\t" + student.getNumber() + "\t" + student.getCourse() + "\t" + student.getId() + "\t" + student.getHouseNumber() + "\t" + student.getStreetName() + "\t" + student.getTown() + "\t" + student.getPostcode());
            }
            writer.close();
        }
    }

    // public static List load(boolean binary, String path) {
    //     ;
    // }
}
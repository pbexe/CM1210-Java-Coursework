/**
 * Program
 */

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

public class Program {

    public static void main(String[] args) throws IOException{
        System.out.println("Hello");
        List<Student> students = new ArrayList<Student>();
        Student s = new Student("Bob bobby", "C123456", "CompSci", "CM1234", "11a", "Bobby st", "A town", "CF1CF");
        students.add(s);
        save(false, "file.tsv", students);
    }

    public static void save(boolean binary, String path, List<Student> students) throws IOException {
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        for (Student student : students) {
            writer.println(student.getName() + "\t" + student.getNumber() + "\t" + student.getCourse() + "\t" + student.getId() + "\t" + student.getHouseNumber() + "\t" + student.getStreetName() + "\t" + student.getTown() + "\t" + student.getPostcode());
        }
        writer.close();
    }

    // public static ArrayList load(boolean binary, String path) {
    //     ;
    // }
}
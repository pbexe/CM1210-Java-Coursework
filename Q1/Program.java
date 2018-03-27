/**
 * Program
 */

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        System.out.println("Hello");
        List<Student> students = new ArrayList<Student>();
        Student s = new Student("Bob bobby", "C123456", "CompSci", "CM1234", "11a", "Bobby st", "A town", "CF1CF");
    }

    // public static void save(boolean binary, String path, List students) {
    //     PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
    //     for (Student student : students) {
    //         writer.println(student.);
    //     }
    //     writer.close();
    // }

    // public static List load(boolean binary, String path) {
    //     ;
    // }
}
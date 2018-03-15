/**
 * Student
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Student {
    String name;
    String number;
    String course;
    String id;
    String houseNumber;
    String streetName;
    String town;
    String postcode;

    public Student(String name, String number, String course, String id, String houseNumber, String streetName, String town, String postcode) {
        Pattern patternName = Pattern.compile("^[A-z| ]+$");
        Matcher matcherName = patternName.matcher(name);
        boolean matchFoundName = matcherName.matches();

        Pattern patternNumber = Pattern.compile("^C[1-9]{6}$");
        Matcher matcherNumber = patternNumber.matcher(number);
        boolean matchFoundNumber = matcherNumber.matches();

        Pattern patternCourse = Pattern.compile("^[A-z| ]+$");
        Matcher matcherCourse = patternCourse.matcher(course);
        boolean matchFoundCourse = matcherCourse.matches();

        Pattern patternId = Pattern.compile("^[A-Z]{2}[0-9]{4}$");
        Matcher matcherId = patternId.matcher(id);
        boolean matchFoundId = matcherId.matches();

        Pattern patternHouseNumber = Pattern.compile("^[0-9]+[A-z]?$");
        Matcher matcherHouseNumber = patternHouseNumber.matcher(houseNumber);
        boolean matchFoundHouseNumber = matcherHouseNumber.matches();

        Pattern patternStreetName = Pattern.compile("^[A-z| ]+$");
        Matcher matcherStreetName = patternStreetName.matcher(streetName);
        boolean matchFoundStreetName = matcherStreetName.matches();

        Pattern patternTown = Pattern.compile("^[A-z| ]+$");
        Matcher matcherTown = patternTown.matcher(town);
        boolean matchFoundTown = matcherTown.matches();

        Pattern patternPostcode = Pattern.compile("^[A-Z]{2}[0-9][A-Z]{2}$");
        Matcher matcherPostcode = patternPostcode.matcher(postcode);
        boolean matchFoundPostcode = matcherPostcode.matches();

        if (matchFoundName && matchFoundNumber && matchFoundId && matchFoundHouseNumber && matchFoundStreetName && matchFoundCourse && matchFoundTown && matchFoundPostcode){
            this.name = name;
            this.number = number;
            this.course = course;
            this.id = id;
            this.houseNumber = houseNumber;
            this.streetName = streetName;
            this.town = town;
            this.postcode = postcode;
        } else {
            throw new IllegalArgumentException("Invalid constructor arguments");
        }
    }
}
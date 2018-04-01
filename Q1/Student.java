/**
* Student
*/

import java.util.regex.Pattern;
import java.io.Serializable;
import java.util.regex.Matcher;


public class Student implements Serializable{
    private String name;
    private String number;
    private String course;
    private String id;
    private String houseNumber;
    private String streetName;
    private String town;
    private String postcode;
    static final long serialVersionUID = 1L;

    public Student(String name, String number, String course, String id, String houseNumber, String streetName, String town, String postcode) {
        setName(name);
        setNumber(number);
        setCourse(course);
        setId(id);
        setHouseNumber(houseNumber);
        setStreetName(streetName);
        setTown(town);
        setPostcode(postcode);
    }

    public Student(){
        ; // Allow building of the student class attribute by attribute
    }

    /**
    * @return the name
    */
    public String getName() {
        return name;
    }

    /**
    * @return the number
    */
    public String getNumber() {
        return number;
    }

    /**
    * @return the course
    */
    public String getCourse() {
        return course;
    }

    /**
    * @return the id
    */
    public String getId() {
        return id;
    }

    /**
    * @return the houseNumber
    */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
    * @return the streetName
    */
    public String getStreetName() {
        return streetName;
    }

    /**
    * @return the town
    */
    public String getTown() {
        return town;
    }

    /**
    * @return the postcode
    */
    public String getPostcode() {
        return postcode;
    }

    /**
    * @param name the name to set
    */
    public void setName(String name) throws IllegalArgumentException {
        Pattern patternName = Pattern.compile("^[A-z| ]+$");
        Matcher matcherName = patternName.matcher(name);
        boolean matchFoundName = matcherName.matches();
        if (matchFoundName){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    /**
    * @param id the id to set
    */
    public void setId(String id) throws IllegalArgumentException {
        Pattern patternId = Pattern.compile("^[A-Z]{2}[0-9]{4}$");
        Matcher matcherId = patternId.matcher(id);
        boolean matchFoundId = matcherId.matches();
        if (matchFoundId) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    /**
    * @param number the number to set
    */
    public void setNumber(String number) throws IllegalArgumentException {
        Pattern patternNumber = Pattern.compile("^C[1-9]{6}$");
        Matcher matcherNumber = patternNumber.matcher(number);
        boolean matchFoundNumber = matcherNumber.matches();
        if (matchFoundNumber) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Invalid number");
        }
    }

    /**
    * @param course the course to set
    */
    public void setCourse(String course) throws IllegalArgumentException {
        Pattern patternCourse = Pattern.compile("^[A-z| ]+$");
        Matcher matcherCourse = patternCourse.matcher(course);
        boolean matchFoundCourse = matcherCourse.matches();
        if (matchFoundCourse) {
            this.course = course;
        } else {
            throw new IllegalArgumentException("Invalid course");
        }
    }

    /**
    * @param houseNumber the houseNumber to set
    */
    public void setHouseNumber(String houseNumber) throws IllegalArgumentException {
        Pattern patternHouseNumber = Pattern.compile("^[0-9]+[A-z]?$");
        Matcher matcherHouseNumber = patternHouseNumber.matcher(houseNumber);
        boolean matchFoundHouseNumber = matcherHouseNumber.matches();
        if (matchFoundHouseNumber) {
            this.houseNumber = houseNumber;
        } else {
            throw new IllegalArgumentException("Invalid house number");
        }
    }

    /**
    * @param streetName the streetName to set
    */
    public void setStreetName(String streetName) throws IllegalArgumentException {
        Pattern patternStreetName = Pattern.compile("^[A-z| ]+$");
        Matcher matcherStreetName = patternStreetName.matcher(streetName);
        boolean matchFoundStreetName = matcherStreetName.matches();
        if (matchFoundStreetName) {
            this.streetName = streetName;
        } else {
            throw new IllegalArgumentException("Invalid street name");
        }
    }

    /**
    * @param town the town to set
    */
    public void setTown(String town) throws IllegalArgumentException {
        Pattern patternTown = Pattern.compile("^[A-z| ]+$");
        Matcher matcherTown = patternTown.matcher(town);
        boolean matchFoundTown = matcherTown.matches();
        if (matchFoundTown) {
            this.town = town;
        } else {
            throw new IllegalArgumentException("Invalid town");
        }
    }

    /**
    * @param postcode the postcode to set
    */
    public void setPostcode(String postcode) throws IllegalArgumentException {
        Pattern patternPostcode = Pattern.compile("^[A-Z]{2}[0-9][A-Z]{2}$");
        Matcher matcherPostcode = patternPostcode.matcher(postcode);
        boolean matchFoundPostcode = matcherPostcode.matches();
        if (matchFoundPostcode) {
            this.postcode = postcode;
        } else {
            throw new IllegalArgumentException("Invalid postcode");
        }
    }
}
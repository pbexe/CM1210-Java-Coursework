/**
* Student
*/

import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Class that represents an individual student
 *
 * @see Program
 */
public class Student implements Serializable{
    // Interface Serializable retrieved 03/04/18
    // https://docs.oracle.com/javase/9/docs/api/java/io/Serializable.html

    // Declare the attributes
    private String name;
    private String number;
    private String course;
    private String id;
    private String houseNumber;
    private String streetName;
    private String town;
    private String postcode;

    // Used as a version number so that it can be checked whether the object being loaded is the same version as the class
    static final long serialVersionUID = 14L;

    /**
     * Main constructor for the student
     *
     * @param name The name of the student
     * @param number The student's number
     * @param course The course that the student is currently doing
     * @param id The ID of that course
     * @param houseNumber The house number of the student
     * @param streetName The name of the student's street
     * @param town The town that the student lives in
     * @param postcode The student's postcode
     */
    public Student(String name, String number, String course, String id, String houseNumber, String streetName, String town, String postcode) {
        // Call each of the setters because they have validation on them
        setName(name);
        setNumber(number);
        setCourse(course);
        setId(id);
        setHouseNumber(houseNumber);
        setStreetName(streetName);
        setTown(town);
        setPostcode(postcode);
    }

    /**
     * Allow building of the student class attribute by attribute
     */
    public Student() {
        ;
    }

    /**
    * @return the name
    */
    public String getName() {
        return name;
    }

    /**
    * @return the student number
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
    * @return the course id
    */
    public String getId() {
        return id;
    }

    /**
    * @return the house number
    */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
    * @return the street name
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

    public static boolean isValid(String patternString, String value) {
        // Class Pattern retrieved 03/04/18
        // https://docs.oracle.com/javase/9/docs/api/java/util/regex/Pattern.html
        // Instantiate pattern object
        Pattern pattern = Pattern.compile(patternString);
        // Create a matcher object using this pattern
        Matcher matcher = pattern.matcher(value);
        // Were there any matches?
        boolean matches = matcher.matches();
        return matches;
    }

    /**
    * Sets the name of the student and validates it
    *
    * @param name the name to set
    */
    public void setName(String name) throws IllegalArgumentException {
        boolean match = isValid("^[A-z| ]+$", name);
        if (match){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    /**
    * Sets the ID of the student's course and validates it
    *
    * @param id the id to set
    */
    public void setId(String id) throws IllegalArgumentException {
        boolean match = isValid("^[A-Z]{2}[0-9]{4}$", id);
        if (match) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    /**
    * Sets the number of the student and validates it
    *
    * @param number the number to set
    */
    public void setNumber(String number) throws IllegalArgumentException {
        boolean match = isValid("^C[1-9]{6}$", number);
        if (match) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("Invalid number");
        }
    }

    /**
    * Sets the course of the student and validates it
    *
    * @param course the course to set
    */
    public void setCourse(String course) throws IllegalArgumentException {
        boolean match = isValid("^[A-z| ]+$", course);
        if (match) {
            this.course = course;
        } else {
            throw new IllegalArgumentException("Invalid course");
        }
    }

    /**
    * Sets the house number of the student and validates it
    *
    * @param houseNumber the house number to set
    */
    public void setHouseNumber(String houseNumber) throws IllegalArgumentException {
        boolean match = isValid("^[0-9]+[A-z]?$", houseNumber);
        if (match) {
            this.houseNumber = houseNumber;
        } else {
            throw new IllegalArgumentException("Invalid house number");
        }
    }

    /**
    * Sets the street name of the student and validates it
    *
    * @param streetName the streetName to set
    */
    public void setStreetName(String streetName) throws IllegalArgumentException {
        boolean match = isValid("^[A-z| ]+$", streetName);
        if (match) {
            this.streetName = streetName;
        } else {
            throw new IllegalArgumentException("Invalid street name");
        }
    }

    /**
    * Sets the town of the student and validates it
    *
    * @param town the town to set
    */
    public void setTown(String town) throws IllegalArgumentException {
        boolean match = isValid("^[A-z| ]+$", town);
        if (match) {
            this.town = town;
        } else {
            throw new IllegalArgumentException("Invalid town");
        }
    }

    /**
    * Sets the postcode of the student and validates it
    *
    * @param postcode the postcode to set
    */
    public void setPostcode(String postcode) throws IllegalArgumentException {
        boolean match = isValid("^[A-Z]{2}[0-9][A-Z]{2}$", postcode);
        if (match) {
            this.postcode = postcode;
        } else {
            throw new IllegalArgumentException("Invalid postcode");
        }
    }
}
/**
 * Tetra
 */
public class Tetra extends Fish {

    /**
     * Constructor for the {@code Tetra} class
     *
     * @param isAlive Whether the pet is alive
     * @param isHungry Whether the pet is hungry
     * @param age The age of the pet
     * @param weight The weight of the pet
     * @param name The name of the pet
     */
    public Tetra(boolean isAlive, boolean isHungry, int age, float weight, String name) {
        super(isAlive, isHungry, age, weight, name);
    }

    /**
     * Gets the colour of the fish
     *
     * @return A description of the colour of the dog
     */
    public String getColour() {
        return "Silver";
    }

    /**
     * Make the tetra eat and adjust its attributes accordingly
     */
    public void eat() {
        setWeight(getWeight() + 1);
        setIsHungry(false);
        if (getWeight() > 5 || getWeight() < 3) {
            setIsAlive(false);
        }
    }
}
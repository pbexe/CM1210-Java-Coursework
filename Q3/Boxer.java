/**
 * Boxer
 */
public class Boxer extends Dog{

    /**
     * Constructor for the {@code Boxer} class
     *
     * @param isAlive Whether the pet is alive
     * @param isHungry Whether the pet is hungry
     * @param age The age of the pet
     * @param weight The weight of the pet
     * @param name The name of the pet
     * @param goodBoy Whether the dog is a good boy
     */
    public Boxer(boolean isAlive, boolean isHungry, int age, float weight, String name, boolean goodBoy) {
        super(isAlive, isHungry, age, weight, name, goodBoy);
    }

    /**
     * Gets the colour of the dog
     *
     * @return A description of the colour of the dog
     */
    public String getColour() {
        return "Brown";
    }

    /**
     * Make the boxer eat and adjust its attributes accordingly
     */
    public void eat() {
        setWeight(getWeight() + 1);
        setIsHungry(false);
        if (getWeight() > 15000 || getWeight() < 8000) {
            setIsAlive(false);
        }
    }
}
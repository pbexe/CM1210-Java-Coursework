/**
 * SpringerSpaniel
 */
public class SpringerSpaniel extends Dog {

    /**
     * Constructor for the {@code SpringerSpaniel} class
     *
     * @param isAlive Whether the pet is alive
     * @param isHungry Whether the pet is hungry
     * @param age The age of the pet
     * @param weight The weight of the pet
     * @param name The name of the pet
     * @param goodBoy Whether the dog is a good boy
     */
    public SpringerSpaniel(boolean isAlive, boolean isHungry, int age, float weight, String name, boolean goodboy) {
        super(isAlive, isHungry, age, weight, name, goodboy);
    }

    /**
     * Gets the colour of the dog
     *
     * @return A description of the colour of the dog
     */
    public String getColour() {
        return "White and brown";
    }

    /**
     * Make the springer spaniel eat and adjust its attributes accordingly
     */
    public void eat() {
        setWeight(getWeight() + 1);
        setIsHungry(false);
        if (getWeight() > 20000 || getWeight() < 5000) {
            setIsAlive(false);
        }
    }
}
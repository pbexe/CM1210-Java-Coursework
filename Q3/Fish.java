/**
 * Fish
 */
abstract public class Fish extends Pet{

    /**
     * Constructor for the {@code Fish} class
     *
     * @param isAlive Whether the pet is alive
     * @param isHungry Whether the pet is hungry
     * @param age The age of the pet
     * @param weight The weight of the pet
     * @param name The name of the pet
     */
    public Fish(boolean isAlive, boolean isHungry, int age, float weight, String name) {
        super(isAlive, isHungry, age, weight, name);
    }

    /**
     * Emits a fish-like noise
     */
    public void makeNoise() {
        System.out.println("*Fishy noise*");
    }

    /**
     * Make the fish swim and adjust attributes accordingly
     */
    public void swim() {
        setIsHungry(true);
        setWeight(getWeight() - 1);
    }

}
/**
 * Pet
 */
abstract public class Pet {

    private boolean isAlive;
    private boolean isHungry;
    private int age;
    private float weight;
    private String name;

    public Pet(boolean isAlive, boolean isHungry, int age, float weight, String name) {
        this.isAlive = isAlive;
        this.isHungry = isHungry;
        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    abstract public void makeNoise();

    /**
     * Sets whether the animal is alive
     *
     * @param isAlive Whether the animal is alive or not
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * Sets whether the animal is hungry or not
     *
     * @param isHungry Whether the animal is hungry
     */
    public void setIsHungry(boolean isHungry) {
        this.isHungry = isHungry;
    }

    /**
     * Sets the age
     *
     * @param age The age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the name
     *
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the weight
     *
     * @param weight The weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Gets the age
     *
     * @return The age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the name
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the weight
     *
     * @return The weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Gets whether it is alive
     *
     * @return Is alive
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Gets whether it is hungry
     *
     * @return Is Hungry
     */
    public boolean getIsHungry() {
        return isHungry;
    }

}
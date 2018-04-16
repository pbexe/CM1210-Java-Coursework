/**
 * Dog
 */
abstract public class Dog extends Pet {

    private boolean goodBoy;

    /**
     * Constructor for the {@code Dog} class
     *
     * @param isAlive Whether the pet is alive
     * @param isHungry Whether the pet is hungry
     * @param age The age of the pet
     * @param weight The weight of the pet
     * @param name The name of the pet
     * @param goodBoy Whether the dog is a good boy
     */
    public Dog(boolean isAlive, boolean isHungry, int age, float weight, String name, boolean goodBoy) {
        super(isAlive, isHungry, age, weight, name);
        this.goodBoy = goodBoy;
    }

    /**
     * Makes the dog emit a dog-like noise
     */
    public void makeNoise() {
        System.out.println("Woof");
    }

    /**
     * Sets whether the dog is a good boy
     *
     * @param goodBoy Whether the dog is a good boy
     */
    public void setIsGoodBoy(boolean goodBoy) {
        this.goodBoy = goodBoy;
    }

    /**
     * Whether the dog is a good boy
     *
     * @return Whether the dog is a good boy
     */
    public boolean isGoodBoy() {
        return this.goodBoy;
    }
}
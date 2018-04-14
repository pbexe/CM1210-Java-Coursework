/**
 * Dog
 */
abstract public class Dog extends Pet {

    private boolean goodBoy;

    public Dog(boolean isAlive, boolean isHungry, int age, float weight, String name, boolean goodBoy) {
        super(isAlive, isHungry, age, weight, name);
        this.goodBoy = goodBoy;
    }

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
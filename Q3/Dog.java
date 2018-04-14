/**
 * Dog
 */
public class Dog extends Pet {

    public Dog(boolean isAlive, boolean isHungry, int age, float weight, String name) {
        super(isAlive, isHungry, age, weight, name);
    }

    public void makeNoise() {
        System.out.println("Woof");
    }
}
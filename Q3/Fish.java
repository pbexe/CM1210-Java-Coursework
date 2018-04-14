/**
 * Fish
 */
public class Fish extends Pet{

    public Fish(boolean isAlive, boolean isHungry, int age, float weight, String name) {
        super(isAlive, isHungry, age, weight, name);
    }

    public void makeNoise() {
        System.out.println("*Fishy noise*");
    }

    public void eat() {
        setWeight(getWeight() + 1);
        setIsHungry(false);
        if (getWeight() > 5) {
            setIsAlive(false);
        }
    }
}
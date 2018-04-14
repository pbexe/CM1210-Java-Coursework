/**
 * Fish
 */
abstract public class Fish extends Pet{

    public Fish(boolean isAlive, boolean isHungry, int age, float weight, String name) {
        super(isAlive, isHungry, age, weight, name);
    }

    public void makeNoise() {
        System.out.println("*Fishy noise*");
    }

    public void swim() {
        setIsHungry(true);
        setWeight(getWeight() - 1);
    }

}
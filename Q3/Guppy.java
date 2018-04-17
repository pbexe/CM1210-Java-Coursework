/**
 * Guppy
 */
public class Guppy extends Fish {

    public Guppy(boolean isAlive, boolean isHungry, int age, float weight, String name) {
        super(isAlive, isHungry, age, weight, name);
    }

    public String getColour() {
        return "Orange";
    }

    public void eat() {
        setWeight(getWeight() + 1);
        setIsHungry(false);
        if (getWeight() > 6 || getWeight() < 4) {
            setIsAlive(false);
        }
    }
}
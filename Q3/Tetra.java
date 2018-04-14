/**
 * Tetra
 */
public class Tetra extends Fish {

    public Tetra(boolean isAlive, boolean isHungry, int age, float weight, String name) {
        super(isAlive, isHungry, age, weight, name);
    }

    public String getColour() {
        return "Silver";
    }

    public void eat() {
        setWeight(getWeight() + 1);
        setIsHungry(false);
        if (getWeight() > 5 || getWeight() < 3) {
            setIsAlive(false);
        }
    }
}
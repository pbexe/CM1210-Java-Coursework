/**
 * Boxer
 */
public class Boxer extends Dog{

    public Boxer(boolean isAlive, boolean isHungry, int age, float weight, String name, boolean goodBoy) {
        super(isAlive, isHungry, age, weight, name, goodBoy);
    }

    public String getColour() {
        return "Brown";
    }

    public void eat() {
        setWeight(getWeight() + 1);
        setIsHungry(false);
        if (getWeight() > 15000 || getWeight() < 8000) {
            setIsAlive(false);
        }
    }
}
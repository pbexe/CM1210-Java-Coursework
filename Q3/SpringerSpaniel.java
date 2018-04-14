/**
 * SpringerSpaniel
 */
public class SpringerSpaniel extends Dog {

    public SpringerSpaniel(boolean isAlive, boolean isHungry, int age, float weight, String name, boolean goodboy) {
        super(isAlive, isHungry, age, weight, name, goodboy);
    }

    public String getColour() {
        return "White and brown";
    }

    public void eat() {
        setWeight(getWeight() + 1);
        setIsHungry(false);
        if (getWeight() > 20000 || getWeight() < 5000) {
            setIsAlive(false);
        }
    }
}
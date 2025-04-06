package students.items;

public abstract class Food extends Item {
    // Constructor for Food items, passed to the superclass (Item)
    public Food(int maturationAge, int deathAge, int monetaryValue) {
        super(maturationAge, deathAge, monetaryValue);
    }
    public void increaseMaturationTime() {
        setMaturationAge(getMaturationAge() + 1);
    }
}
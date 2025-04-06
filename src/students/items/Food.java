package students.items;

public abstract class Food extends Item {
    // Constructor that calls the Item constructor
    public Food(int maturationAge, int deathAge, int monetaryValue) {
        super(maturationAge, deathAge, monetaryValue);
    }
}

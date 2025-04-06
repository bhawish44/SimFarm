package students.items;

public class Weed extends Item {

    // Constructor for Weed
    public Weed() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1); // Infinite maturation and death ages, negative value
    }

    @Override
    public String toString() {
        return "#"; // Weeds are represented as "#"
    }
}

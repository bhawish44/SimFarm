package students.items;

public class Soil extends Item {

    // Constructor for Soil
    public Soil() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, 0); // Infinite maturation and death ages, zero value
    }

    @Override
    public String toString() {
        return "."; // Soil is represented as "."
    }
}

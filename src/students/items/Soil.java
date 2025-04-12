package students.items;

public class Soil extends Item {
    public Soil() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, 0);  // Soil has infinite maturation and death age, and 0 value
    }

    @Override
    public String toString() {
        return ".";  // Representing soil as "."
    }
}

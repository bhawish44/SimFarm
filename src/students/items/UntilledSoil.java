package students.items;

public class UntilledSoil extends Item {

    // Constructor for UntilledSoil
    public UntilledSoil() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1); // Infinite maturation and death ages, negative value
    }

    @Override
    public String toString() {
        return "/"; // Untilled soil is represented as "/"
    }
}

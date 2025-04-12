package students.items;

public class UntilledSoil extends Item {
    public UntilledSoil() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);  // Untilled soil has infinite maturation and death age, and -1 value
    }

    @Override
    public String toString() {
        return "/";  // Representing untilled soil as "/"
    }
}
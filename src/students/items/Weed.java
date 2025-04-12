package students.items;

public class Weed extends Item {
    public Weed() {
        super(Integer.MAX_VALUE, Integer.MAX_VALUE, -1);  // Weed has infinite maturation and death age, and -1 value
    }

    @Override
    public String toString() {
        return "#";  // Representing weed as "#"
    }
}
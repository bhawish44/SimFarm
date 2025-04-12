package students.items;

public class Apples extends Food {
    private static int generationCount = 0;

    public Apples() {
        super(3, 5, 3);  // Maturation age, death age, and value
        generationCount++;
    }

    public static int getGenerationCount() {
        return generationCount;
    }

    @Override
    public String toString() {
        // If the apple is immature (age < maturationAge), it will show as "a"
        // If mature, it will show as "A"
        return (age < maturationAge) ? "a" : "A";
    }

    @Override
    public int getValue() {
        // Ensure the value is returned when mature (3 dollars for a mature apple)
        return (age >= maturationAge) ? monetaryValue : 0;
    }
}
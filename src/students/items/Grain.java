package students.items;

public class Grain extends Food {
    private static int generationCount = 0;

    public Grain() {
        super(2, 6, 2);  // Maturation age, death age, and value
        generationCount++;
    }

    public static int getGenerationCount() {
        return generationCount;
    }

    @Override
    public String toString() {
        return (age < maturationAge) ? "g" : "G";  // "g" if immature, "G" if mature
    }
}

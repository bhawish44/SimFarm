package students.items;

public class Grain extends Food {
    private static int generationCount = 0; // Keeps track of the number of Grain objects created

    // Constructor for Grain
    public Grain() {
        super(2, 6, 2); // Maturation age: 2, Death age: 6, Value: 2
        generationCount++;
    }

    // Static method to get the number of Grains created
    public static int getGenerationCount() {
        return generationCount;
    }

    @Override
    public String toString() {
        return (this.died()) ? "G" : "g"; // Print "G" if mature, "g" if immature
    }
}

package students.items;

public class Apples extends Food {
    private static int generationCount = 0; // Keeps track of the number of Apple objects created

    // Constructor for Apple
    public Apples() {
        super(3, 5, 3); // Maturation age: 3, Death age: 5, Value: 3
        generationCount++;
    }

    // Static method to get the number of Apples created
    public static int getGenerationCount() {
        return generationCount;
    }

    @Override
    public String toString() {
        return (this.died()) ? "A" : "a"; // Print "A" if mature, "a" if immature
    }
}
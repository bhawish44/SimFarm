package students.items;

public class Apples extends Food {
    private static int generationCount = 0; // Tracks the number of Apples created

    // Constructor for Apples
    public Apples() {
        super(3, 5, 3); // Apple has maturation age 3, death age 5, and value 3
        generationCount++; // Increment the generation count whenever a new Apple is created
    }

    // Method to return the total number of Apple instances created
    public static int getGenerationCount() {
        return generationCount; // Simply return the current count of created Apples
    }

    // Method to represent the Apple as a string. It shows 'a' if it's immature, or 'A' if it's ripe.
    @Override
    public String toString() {
        // If the Apple is younger than its maturation age, return 'a'
        if (this.getAge() < this.getMaturationAge()) {
            return "a"; // Immature apple
        }
        return "A"; // Mature apple
    }
}

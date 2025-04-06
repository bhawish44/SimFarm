package students.items;

public abstract class Item {
    private int age;
    private int maturationAge;
    private int deathAge;
    private int monetaryValue;

    // Constructor for Item class
    public Item(int maturationAge, int deathAge, int monetaryValue) {
        this.age = 0; // All items start at age 0
        this.maturationAge = maturationAge;
        this.deathAge = deathAge;
        this.monetaryValue = monetaryValue;
    }

    // Method to increment age
    public void tick() {
        this.age++;
    }

    // Set age directly
    public void setAge(int age) {
        this.age = age;
    }

    // Check if item has died
    public boolean died() {
        return this.age > this.deathAge;
    }

    // Get value based on maturation age
    public int getValue() {
        if (this.age >= this.maturationAge) {
            return this.monetaryValue;
        }
        return 0;
    }

    // Getters
    public int getAge() {
        return this.age;
    }

    public int getMaturationAge() {
        return this.maturationAge;
    }

    public int getDeathAge() {
        return this.deathAge;
    }

    // Abstract toString method to be implemented in subclasses
    public abstract String toString();
}

package students.items;

public abstract class Item {
    private int age;
    private int maturationAge;
    private int deathAge;
    private int monetaryValue;

    // Constructor for Item, initializes the properties
    public Item(int maturationAge, int deathAge, int monetaryValue) {
        this.age = 0; // All items start at age 0
        this.maturationAge = maturationAge;
        this.deathAge = deathAge;
        this.monetaryValue = monetaryValue;
    }

    // Method to tick the item (age it)
    public void tick() {
        age++;
    }

    // Method to set the age of the item
    public void setAge(int age) {
        this.age = age;
    }

    // Method to check if the item has died (if age is greater than deathAge)
    public boolean died() {
        return age > deathAge;
    }

    // Method to get the value of the item
    public int getValue() {
        if (age >= maturationAge) {
            return monetaryValue; // Only return value if the item has matured
        }
        return 0;
    }

    // Method to compare this item with another object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Item item = (Item) obj;
        return age == item.age && maturationAge == item.maturationAge && 
               deathAge == item.deathAge && monetaryValue == item.monetaryValue;
    }

    // Abstract method to get the string representation of the item (implemented by subclasses)
    public abstract String toString();
}

package students.items;

public abstract class Item {
    private int age;
    private int maturationAge;
    private int deathAge;
    private int monetaryValue;

    // Constructor for Item
    public Item(int maturationAge, int deathAge, int monetaryValue) {
        this.age = 0;
        this.maturationAge = maturationAge;
        this.deathAge = deathAge;
        this.monetaryValue = monetaryValue;
    }

    // Advance the age of the item
    public void tick() {
        age++;
    }

    // Set a specific age
    public void setAge(int age) {
        this.age = age;
    }

    // Check if the item has died
    public boolean died() {
        return age > deathAge;
    }

    // Get the value only if matured
    public int getValue() {
        return age >= maturationAge ? monetaryValue : 0;
    }

    // Compare items
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Item item = (Item) obj;
        return age == item.age &&
               maturationAge == item.maturationAge &&
               deathAge == item.deathAge &&
               monetaryValue == item.monetaryValue;
    }

    // Abstract method for symbol printing
    public abstract String toString();

    // ✅ NEW: Get and set methods for maturationAge (for WeatherSystem drought effect)
    public int getMaturationAge() {
        return maturationAge;
    }

    public void setMaturationAge(int maturationAge) {
        this.maturationAge = maturationAge;
    }
}

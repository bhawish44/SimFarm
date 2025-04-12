package students.items;

public abstract class Item {
    protected int age;
    protected int maturationAge;
    protected int deathAge;
    protected int monetaryValue;

    public Item(int maturationAge, int deathAge, int monetaryValue) {
        this.age = 0;
        this.maturationAge = maturationAge;
        this.deathAge = deathAge;
        this.monetaryValue = monetaryValue;
    }

    public void tick() {
        age++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean died() {
        return age > deathAge;
    }

    public int getValue() {
        return (age >= maturationAge) ? monetaryValue : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return age == item.age &&
               maturationAge == item.maturationAge &&
               deathAge == item.deathAge &&
               monetaryValue == item.monetaryValue;
    }

    public abstract String toString();
}
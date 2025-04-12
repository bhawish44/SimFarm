package marking;

import students.Farm;
import students.Field;
import students.items.*;

public class Marker {

    public static void main(String[] args) {

        // Section ONE
        // you should NOT be able to make an Item - following line shouldn't compile if uncommented
        // new Item(0, 0, 0);

        System.out.println(Apples.getGenerationCount()); // should print 0
        Apples a = new Apples();
        System.out.println(Apples.getGenerationCount()); // should print 1
        System.out.println(a); // should print "a"
        System.out.println(a.getValue()); // should print 0
        a.setAge(5);
        System.out.println(a.getValue()); // should print 3
        System.out.println(a); // should print "A"
        System.out.println(a.died()); // should print false

        a.tick();
        System.out.println(a.died()); // should print true
        Food testFood = a; // this should be possible
        Item testItem = testFood; // this should be possible

        System.out.println(new Weed()); // should print "#"
        System.out.println(new UntilledSoil()); // should print "/"

        // Section TWO
        // uncomment this section once you get to it
        Field testField = new Field(5, 5);
        System.out.println(testField.get(3, 3)); // should print "."
        System.out.println(testField); // should print the field
        System.out.println(testField.getValue()); // should print 0
        a = new Apples();
        a.setAge(5);
        testField.plant(0, 0, a);
        System.out.println(testField.getValue()); // should print 3
        System.out.println(a.equals(testField.get(0, 0))); // should print true
        testField.till(0, 0);
        System.out.println(a.equals(testField.get(0, 0))); // should print false
        System.out.println(testField.get(0, 0).equals(new Soil())); // should print true

        // Section THREE
        // uncomment this section once you get to it
        // remember, your farm should work on varies size fields (assuming all fields are less than 10x10)
        Farm f = new Farm(10, 5, 10);
        f.run();

        // Section FOUR - Market Functionality (Step 4)
        // Initialize the market with $10
        Market market = new Market(10);

        // Show the initial balance
        System.out.println("\nInitial balance: $" + market.getBalance());

        // Attempt to buy apples and grain
        market.buy("apple");  // Should succeed and deduct $2
        market.buy("grain");  // Should succeed and deduct $1
        market.buy("apple");  // Should succeed and deduct $2 again

        // Show the updated balance after buying
        System.out.println("Balance after purchases: $" + market.getBalance());

        // Create a crop (Apple) and sell it
        Apples appleToSell = new Apples();
        appleToSell.setAge(5);  // Make it mature for selling

        market.sell(appleToSell);  // Should sell and add $3

        // Show the final balance after selling
        System.out.println("Final balance after selling: $" + market.getBalance());
    }
}

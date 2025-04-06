package students;

import students.items.Item;
import students.items.Soil;
import students.items.Weed;
import students.items.Food;
import students.items.UntilledSoil;
import java.util.Random;

public class Field {
    private Item[][] grid;
    private int width;
    private int height;

    // Constructor for Field, initializes with Soil items
    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Item[height][width];

        // Initialize all grid positions with Soil
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Soil(); // Set initial state of the field to Soil
            }
        }
    }

    // Method to simulate the aging of items in the field
    public void tick() {
        Random rand = new Random();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Item item = grid[i][j];
                item.tick(); // Age the item

                // If item is Soil, there is a 20% chance it turns into a Weed
                if (item instanceof Soil && rand.nextInt(100) < 20) {
                    grid[i][j] = new Weed(); // Convert Soil to Weed 20% of the time
                }

                // If the item has died, it turns into UntilledSoil
                if (item.died()) {
                    grid[i][j] = new UntilledSoil(); // Convert dead items to UntilledSoil
                }
            }
        }
    }

    // Method to represent the grid as a string
    @Override
    public String toString() {
        StringBuilder fieldString = new StringBuilder();

        // Print column headers (numbered from 1 to width)
        fieldString.append("  "); // Add a space at the top for row numbers
        for (int i = 1; i <= width; i++) {
            fieldString.append(i).append(" ");  // Print numbers for columns
        }
        fieldString.append("\n");

        // Print each row of the field, starting row numbers from 1
        for (int i = 0; i < height; i++) {
            fieldString.append(i + 1).append(" ");  // Print row number starting from 1
            for (int j = 0; j < width; j++) {
                fieldString.append(grid[i][j].toString()).append(" ");  // Print each item's string representation
            }
            fieldString.append("\n");
        }

        return fieldString.toString(); // Return the complete field as a string
    }

    // Method to till a specific location and turn it into Soil
    public void till(int x, int y) {
        if (x >= 0 && x < height && y >= 0 && y < width) {
            grid[x][y] = new Soil(); // Make the location Soil
        }
    }

    // Method to get the Item at a specific location
    public Item get(int x, int y) {
        if (x >= 0 && x < height && y >= 0 && y < width) {
            return grid[x][y]; // Return the item at the location
        }
        return null;
    }

    // Method to plant an Item (e.g., Apple or Grain) at a specific location
    public void plant(int x, int y, Item item) {
        if (x >= 0 && x < height && y >= 0 && y < width && grid[x][y] instanceof Soil) {
            grid[x][y] = item; // Plant the item in the Soil
        }
    }

    // Method to get the total value of Food items in the field
    public int getValue() {
        int totalValue = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Item item = grid[i][j];
                if (item instanceof Food) {
                    totalValue += item.getValue(); // Only matured Food items add value
                }
            }
        }

        return totalValue; // Return total value
    }

    // Method to get a summary of the field (counts of each item type and total value)
    public String getSummary() {
        int appleCount = 0;
        int grainCount = 0;
        int soilCount = 0;
        int untilledCount = 0;
        int weedCount = 0;
        int totalValue = 0;

        // Loop through the grid and count different items
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Item item = grid[i][j];
                
                if (item instanceof Soil) soilCount++; // Count Soil
                if (item instanceof UntilledSoil) untilledCount++; // Count UntilledSoil
                if (item instanceof Weed) weedCount++; // Count Weeds

                // For Food items (Apple, Grain, etc.)
                if (item instanceof Food) {
                    if (item instanceof students.items.Apples) {
                        appleCount++; // Count Apples
                    } else if (item instanceof students.items.Grain) {
                        grainCount++; // Count Grains
                    }
                    totalValue += item.getValue(); // Only matured Food items add value
                }
            }
        }

        // Return the summary in a formatted string
        return String.format(
            "Apples:        %d\nGrain:         %d\nSoil:          %d\nUntilled:      %d\nWeed:          %d\nFor a total of $%d\nTotal apples created: %d\nTotal grain created: %d\n",
            appleCount, grainCount, soilCount, untilledCount, weedCount, totalValue, appleCount, grainCount
        );
    }
}

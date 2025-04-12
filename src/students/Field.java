package students;

import students.items.*;

public class Field {
    private Item[][] grid;

    public Field(int height, int width) {
        grid = new Item[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Soil();  // Initializing with Soil
            }
        }
    }

    public void tick() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j].tick();  // Increase the age of items

                // If the item is soil, 20% chance to turn it into a weed
                if (grid[i][j] instanceof Soil) {
                    if (Math.random() < 0.2) {
                        grid[i][j] = new Weed();  // 20% chance to turn into a weed
                    }
                }

                // If an item has died, convert it to UntilledSoil
                if (grid[i][j].died()) {
                    grid[i][j] = new UntilledSoil();  // Turn into UntilledSoil when the item dies
                }
            }
        }
    }

    public void till(int x, int y) {
        // x is the column, y is the row now
        if (grid[y][x] instanceof Weed) {
            grid[y][x] = new Soil();  // Replacing a weed with soil
        } else {
            grid[y][x] = new Soil();  // Till the specified location (if it’s not a weed)
        }
    }

    public void plant(int x, int y, Item item) {
        // x is the column, y is the row now
        if (grid[y][x] instanceof Soil) {
            grid[y][x] = item;  // Plant the item at the specified location if it's soil
        } else {
            System.out.println("Cannot plant here. Location is not soil.");
        }
    }

    public int harvest(int x, int y) {
        // x is the column, y is the row now
        if (grid[y][x] instanceof Food) {
            Food food = (Food) grid[y][x];
            if (food.getValue() > 0) {
                int value = food.getValue();  // Get the value of the matured food
                grid[y][x] = new Soil();  // Harvest and turn it back into soil
                System.out.println("Sold '" + food.toString() + "' for $" + value);  // Provide feedback
                return value;  // Return the correct value of the food item
            }
        }
        System.out.println("Nothing to harvest or the item is not mature yet.");
        return 0;
    }

    public void getSummary() {
        int apples = 0, grain = 0, weeds = 0, soil = 0, untilled = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] instanceof Apples) {
                    apples++;
                } else if (grid[i][j] instanceof Grain) {
                    grain++;
                } else if (grid[i][j] instanceof Weed) {
                    weeds++;
                } else if (grid[i][j] instanceof Soil) {
                    soil++;
                } else if (grid[i][j] instanceof UntilledSoil) {
                    untilled++;
                }
            }
        }
        System.out.println("Apples:        " + apples);
        System.out.println("Grain:         " + grain);
        System.out.println("Soil:          " + soil);
        System.out.println("Untilled:      " + untilled);
        System.out.println("Weed:          " + weeds);
        System.out.println("For a total of $" + (apples * 3 + grain * 2));  // Simple value calculation
        System.out.println("Total apples created: " + Apples.getGenerationCount());
        System.out.println("Total grain created: " + Grain.getGenerationCount());
    }

    // Added get() method to return the item at a specific position
    public Item get(int x, int y) {
        return grid[y][x];  // Return the item at the specified position (y is row, x is column)
    }

    // Added getValue() method to calculate total value of matured items
    public int getValue() {
        int totalValue = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] instanceof Food) {
                    Food food = (Food) grid[i][j];
                    totalValue += food.getValue();  // Add the value of the matured food
                }
            }
        }
        return totalValue;
    }

    // Implemented toString() method to return a human-readable field grid with row and column numbers
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Add column numbers at the top of the grid
        sb.append("    ");
        for (int i = 1; i <= grid[0].length; i++) {
            sb.append(i).append(" ");
        }
        sb.append("\n");

        // Add row numbers along the left side and display the grid
        for (int i = 0; i < grid.length; i++) {
            sb.append(i + 1).append("   ");  // Row number
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j].toString()).append(" ");  // Item at each position
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
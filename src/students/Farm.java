package students;

import students.items.WeatherSystem;
import students.items.Apples;
import students.items.Grain;
import students.items.Item;
import students.items.Soil;
import students.items.Food;
import java.util.Scanner;


public class Farm {
    private Field field;
    private int funds;  // Player's balance
    private WeatherSystem weatherSystem = new WeatherSystem();


    // Constructor to initialize the Farm with field dimensions and starting funds
    public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
        this.field = new Field(fieldWidth, fieldHeight);  // Create a new Field object
        this.funds = startingFunds;  // Set the initial funds
    }

    // Method to run the farm game
    public void run() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Print the current state of the field and player's bank balance
            System.out.println(field);  // Print the current state of the field
            System.out.println("Bank balance: $" + funds);  // Print the player's current balance
            
            // Display options
            System.out.println("Enter your next action:");
            System.out.println("t x y: till");
            System.out.println("h x y: harvest");
            System.out.println("p x y: plant");
            System.out.println("s: field summary");
            System.out.println("w: wait");
            System.out.println("q: quit");
            
            // Read the user's input
            String input = scanner.nextLine().trim();
            
            // Handle commands that do not require arguments
            if (input.equals("q")) {
                System.out.println("Game over. Final balance: $" + funds);
                break;  // End the game
            } 
            
            if (input.equals("s")) {
                // Print the field summary
                System.out.println(field.getSummary());
            } else if (input.equals("w")) {
                // Skip the user's turn (just age the items in the field)
                field.tick();
            } else {
                // Handle commands that require arguments (e.g., "t x y", "p x y")
                String[] inputArgs = input.split(" ");
                
                if (inputArgs[0].equals("t") && inputArgs.length == 3) {
                    try {
                        int x = Integer.parseInt(inputArgs[1]) - 1;  // Convert to 0-indexed
                        int y = Integer.parseInt(inputArgs[2]) - 1;  // Convert to 0-indexed
                        field.till(x, y);  // Till the soil at position (x, y)
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter valid coordinates.");
                    }
                } else if (inputArgs[0].equals("h") && inputArgs.length == 3) {
                    // Harvesting action (h x y)
                    try {
                        int x = Integer.parseInt(inputArgs[1]) - 1;
                        int y = Integer.parseInt(inputArgs[2]) - 1;
                        Item item = field.get(x, y);
                        if (item instanceof Food && item.getValue() > 0) {
                            // Harvest the food and add its value to the funds
                            funds += item.getValue();
                            System.out.println("Harvested " + item.toString() + " for $" + item.getValue());
                            field.till(x, y);  // Turn the harvested location into soil
                        } else {
                            System.out.println("No food to harvest at this location.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter valid coordinates.");
                    }
                } else if (inputArgs[0].equals("p") && inputArgs.length == 3) {
                    // Planting action (p x y)
                    try {
                        int x = Integer.parseInt(inputArgs[1]) - 1;
                        int y = Integer.parseInt(inputArgs[2]) - 1;
                        Item location = field.get(x, y);

                        // Ensure the location is Soil, not Weed or other items
                        if (location instanceof Soil) {
                            // Ask the user what they want to plant
                            System.out.println("Enter:\n'a' to buy an apple for $2\n'g' to buy grain for $1");
                            String plantChoice = scanner.nextLine().trim();
                            
                            if (plantChoice.equals("a") && funds >= 2) {
                                // Plant an Apple if the player has enough funds
                                Apples apple = new Apples();
                                field.plant(x, y, apple);
                                funds -= 2;  // Deduct the cost of the apple
                                System.out.println("Planted an apple at (" + (x + 1) + ", " + (y + 1) + ")");
                            } else if (plantChoice.equals("g") && funds >= 1) {
                                // Plant Grain if the player has enough funds
                                Grain grain = new Grain();
                                field.plant(x, y, grain);
                                funds -= 1;  // Deduct the cost of the grain
                                System.out.println("Planted grain at (" + (x + 1) + ", " + (y + 1) + ")");
                            } else if (plantChoice.equals("a")) {
                                System.out.println("You don't have enough funds to buy an apple.");
                            } else if (plantChoice.equals("g")) {
                                System.out.println("You don't have enough funds to buy grain.");
                            } else {
                                System.out.println("Invalid choice. No plant was purchased.");
                            }
                        } else {
                            System.out.println("You can only plant in soil.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter valid coordinates.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid command.");
                }
            }

            // Age the field after each turn
            field.tick();
         // Trigger a weather event after each turn (random)
            weatherSystem.triggerWeather(field);
        }
        
        scanner.close();
    }
}
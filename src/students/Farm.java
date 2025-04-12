package students;

import students.items.*;

public class Farm {
    private Field field;
    private int money;

    public Farm(int fieldWidth, int fieldHeight, int startingFunds) {
        this.field = new Field(fieldHeight, fieldWidth);  // Initialize the field
        this.money = startingFunds;  // Set starting funds
    }

    public void run() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            System.out.println(field);  // Display the field grid
            System.out.println("Bank balance: $" + money);
            System.out.println("Enter your next action:");
            System.out.println("t x y: till");
            System.out.println("h x y: harvest");
            System.out.println("p x y: plant");
            System.out.println("s: field summary");
            System.out.println("w: wait");
            System.out.println("q: quit");

            String action = scanner.nextLine();
            String[] parts = action.split(" ");

            switch (parts[0]) {
                case "t":
                    int xTill = Integer.parseInt(parts[1]) - 1;
                    int yTill = Integer.parseInt(parts[2]) - 1;
                    field.till(xTill, yTill);
                    break;
                case "h":
                    int xHarvest = Integer.parseInt(parts[1]) - 1;
                    int yHarvest = Integer.parseInt(parts[2]) - 1;
                    money += field.harvest(xHarvest, yHarvest);  // Add harvested crop value to balance
                    break;
                case "p":
                    int xPlant = Integer.parseInt(parts[1]) - 1;
                    int yPlant = Integer.parseInt(parts[2]) - 1;
                    System.out.println("Enter:");
                    System.out.println(" - 'a' to buy an apple");
                    System.out.println(" - 'g' to buy grain");

                    String plantChoice = scanner.nextLine();
                    // No money deducted here, just planting the item at the location
                    if (plantChoice.equals("a")) {
                        field.plant(xPlant, yPlant, new Apples());  // Plant apple at selected location
                    } else if (plantChoice.equals("g")) {
                        field.plant(xPlant, yPlant, new Grain());  // Plant grain at selected location
                    } else {
                        System.out.println("Invalid choice. Turn forfeited.");
                    }
                    break;
                case "s":
                    field.getSummary();  // Show field summary (items and their values)
                    break;
                case "w":
                    field.tick();  // Progress age of items in the field
                    break;
                case "q":
                    gameRunning = false;  // Quit the game
                    break;
                default:
                    System.out.println("Invalid action. Try again.");
            }
        }
        scanner.close();
    }
}
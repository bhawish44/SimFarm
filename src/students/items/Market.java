package students.items;

import students.items.*;

public class Market {
    private int playerMoney;

    public Market(int initialMoney) {
        this.playerMoney = initialMoney;  // Set the initial balance
    }

    // Function to buy a crop (Apple or Grain)
    public void buy(String itemType) {
        int cost = 0;
        if (itemType.equals("apple")) {
            cost = 2;  // Apple costs $2
        } else if (itemType.equals("grain")) {
            cost = 1;  // Grain costs $1
        }

        if (playerMoney >= cost) {
            playerMoney -= cost;  // Deduct the cost from the balance
            System.out.println("Successfully bought a " + itemType + " for $" + cost);
        } else {
            System.out.println("Insufficient funds to buy a " + itemType);
        }
    }

    // Function to sell a crop (Apple or Grain)
    public void sell(Item item) {
        int sellPrice = 0;

        if (item instanceof Apples) {
            sellPrice = 3;  // Apples sell for $3
        } else if (item instanceof Grain) {
            sellPrice = 2;  // Grain sells for $2
        }

        playerMoney += sellPrice;  // Add the selling price to the player's balance
        System.out.println("Successfully sold " + item.toString() + " for $" + sellPrice);
    }

    // Show the current money balance
    public int getBalance() {
        return playerMoney;
    }
}

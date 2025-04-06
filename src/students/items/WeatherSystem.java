package students.items;

import students.Field;
import students.items.Food;
import students.items.Soil;
import students.items.UntilledSoil;
import students.items.Weed;

import java.util.Random;

public class WeatherSystem {

    // Trigger a random weather event: Flood, Drought, or Plague
    public void triggerWeather(Field field) {
        Random random = new Random();
        int event = random.nextInt(3); // 0 - Flood, 1 - Drought, 2 - Plague

        switch (event) {
            case 0:
                System.out.println("🌊 Flood triggered!");
                flood(field);
                break;
            case 1:
                System.out.println("🔥 Drought triggered!");
                drought(field);
                break;
            case 2:
                System.out.println("🦠 Plague triggered!");
                plague(field);
                break;
        }
    }

    private void flood(Field field) {
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                if (field.get(i, j) instanceof Soil && Math.random() < 0.25) {
                    field.till(i, j); // turn to soil first
                    field.plant(i, j, new Weed());
                }
            }
        }
    }

    private void drought(Field field) {
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
            	if (field.get(i, j) instanceof Food) {
            	    Food food = (Food) field.get(i, j);
            	    food.increaseMaturationTime();
            	}
            }
        }
    }

    private void plague(Field field) {
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                if (field.get(i, j) instanceof Food) {
                    field.till(i, j); // Wipe food by tilling the tile
                }
            }
        }
    }
}

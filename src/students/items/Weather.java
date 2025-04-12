package students.items;

public class Weather {
    private static boolean isGoodWeather;  // Static variable to track weather condition

    // Randomly determine if the weather is good or bad
    public static void changeWeather() {
        isGoodWeather = Math.random() < 0.5;  // 50% chance for good or bad weather
    }

    // Get the current weather condition
    public static boolean isGoodWeather() {
        return isGoodWeather;
    }
}

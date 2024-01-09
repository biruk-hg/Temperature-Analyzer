import java.util.*;

public class TemperatureAnalyzer {
	static Scanner input = new Scanner(System.in);
	static String[] cities = {"Hartford", "Seattle", "Boston"}; //city names array
	static String[] daysOfWeek = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"}; //days of the week array
	static double[][] cityTemperatures = new double[cities.length][daysOfWeek.length]; //2D array to store temps for each city and day
	static double[] average = new double[cities.length]; //cities average temperatures array

	public static void main(String[] args) {
		inputTemperatures();
		getAverageTemperatures();
		System.out.print("Enter a city to get average temperature: ");
		String cityName = input.next();
		getAverageTemperature(cityName);
		getCityNamesWithHighestTemp();
		
		input.close();
	}

	//Method to input temperatures for each city and day
	public static void inputTemperatures() {
		for(int i = 0; i < cities.length; i++) {
			System.out.println("Enter temperatures of " + cities[i] + " for the week:");
			for(int j = 0; j < daysOfWeek.length; j++)
				cityTemperatures[i][j] = input.nextDouble();
			System.out.println();
		}
	}

	//Method to calculate and display average temperatures for each city
	public static double[] getAverageTemperatures() {
		System.out.println("Average temperatures for each city:");
		for(int i = 0; i < cities.length; i++) { //iterates through every city 
			double sum = 0.0;
			for(int j = 0; j < daysOfWeek.length; j++) //iterates to find the sum of temp for the week
				sum += cityTemperatures[i][j]; //stores the sum of temp for the week 
			average[i] = (sum/daysOfWeek.length); //calculates the average temp for each city and stores it in average array
			System.out.println(cities[i] + ": " + average[i] + " degrees");
		}
		System.out.println();
		return average;
	}

	//Method to display the average temperature for a specific city
	public static void getAverageTemperature(String cityName) {
		cityName = cityName.toUpperCase(); //used to compare user's input with the cities in the cities array
		
		boolean found = false; //used to indicate whether user's input is in the cities array
		int index = 0;
		for(int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toUpperCase(); //used to compare user's input with cities in array
			if(cities[i].equals(cityName)) { //checks the user's city in array
				found = true;
				index = i;
			}
		}
		if (found)
			System.out.println("Average temperature in " + cityName + ": " + average[index]);
		else 
			System.out.println("City not found.");
	}

	//Method to display cities with the highest temp
	public static String[] getCityNamesWithHighestTemp() {
		System.out.println();
		System.out.println("City with the highest temperature each day: ");
		String[] cityWithHighTemp = new String[daysOfWeek.length]; //array of cities with highest temp for each day
		int cityWithHighTempIndex = 0; //stores index of the city with highest temperature for each day
		
		for(int i = 0; i < daysOfWeek.length; i++) {
			double max = 0.0;
			for(int j = 0; j < cities.length; j++) {
				if(cityTemperatures[j][i] > max) { //checks the max temp for each day across all cities
					max = cityTemperatures[j][i];
					cityWithHighTempIndex = j;
				}
			}
			cityWithHighTemp[i] = cities[cityWithHighTempIndex]; //stores the cities from cityList in array
			System.out.println(daysOfWeek[i] + ": " + cityWithHighTemp[i]);
		}
		return cityWithHighTemp;
	}
}
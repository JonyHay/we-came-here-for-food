package hack;

import game2D.Animation;

public class Cities {

	private City[] cities;
	final private int numberOfCities = 1;
	
	public Cities(){
		cities = new City[numberOfCities];

		// city 1, Glasgow
		Animation a = new Animation();
		int population = 1200, zombies = 2;
		cities[0] = new City("New Glasgow", population, zombies, a);
		
		// city 2 Istanbul
		zombies = 0;
		cities[1] = new City("Istanbul", 550000, zombies, a);

		// city 3 Moscow
		zombies = 0;
		cities[2] = new City("Moscow", 12000000, zombies, a);
		
		// city 4 Tokyo
		zombies = 30;
		cities[3] = new City("Tokyo", 13000000, zombies, a);
		
		// city 5 Delhi
		zombies = 0;
		cities[4] = new City("Delhi", 11000000, zombies, a);
		
		// city 6 Sao Paulo
		zombies = 0;
		cities[5] = new City("Sao Paulo", 11000000, zombies, a);
		
		// city 7 Limo
		zombies = 20;
		cities[6] = new City("Limo", 7600000, zombies, a);
		
		// city 8 Mexico
		zombies = 0;
		cities[7] = new City("Mexico", 11000000, zombies, a);
		
		// city 9 New York
		zombies = 5;
		cities[8] = new City("New York", 19000000, zombies, a);
		
		// city 10 Lagos
		zombies = 200;
		cities[9] = new City("Lagos", 21000000, zombies, a);
		
		// city 11 Cairo
		zombies = 0;
		cities[10] = new City("Cairo", 10000000, zombies, a);
		
		// city 12 Johannesburg
		zombies = 9;
		cities[11] = new City("Johannesburg", 950000, zombies, a);
		
		// city 13 Sydney
		zombies = 1;
		cities[12] = new City("Sydney", 4000000, zombies, a);
	}
	
	public City getCityByName(String name){
		int index = 0;
		for (int i = 0; i < numberOfCities; i++) {
			if (cities[i].getCityName().equals(name))
				index = i;
		}
		return cities[index];
	}
	public City getCityByIndex(int i) {
		if (i < numberOfCities)
			return cities[i];
		return null;
	}
	public int getNumberOfCities(){
		return numberOfCities;
	}
}

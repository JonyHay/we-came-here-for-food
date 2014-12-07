package hack;

import java.awt.Toolkit;

import game2D.Animation;

public class Cities {

	private City[] cities;
	final private int numberOfCities = 13;
	
	public Animation[] animations;
	
	public Cities(){
		
		animations = new Animation[3];
		
		animations[0] = new Animation();
		animations[0].addFrame(Toolkit.getDefaultToolkit().createImage("res/green.png"), 1000);
		
		animations[1] = new Animation();
		animations[1].addFrame(Toolkit.getDefaultToolkit().createImage("res/orange.png"), 1000);
		
		animations[2] = new Animation();
		animations[2].addFrame(Toolkit.getDefaultToolkit().createImage("res/red.png"), 1000);
		
		cities = new City[numberOfCities];

		// city 1, Glasgow
		Animation a = animations[0];
		int population = 1200, zombies = 2;
		cities[0] = new City("New Glasgow", population, zombies, a);
		cities[0].setX(647);
		cities[0].setY(185);
		
		// city 2 Istanbul
		zombies = 2;
		cities[1] = new City("Istanbul", 550000, zombies, a);
		cities[1].setX(770);
		cities[1].setY(230);

		// city 3 Moscow
		zombies = 2;
		cities[2] = new City("Mosheep", 12000000, zombies, a);
		cities[2].setX(950);
		cities[2].setY(200);
		
		// city 4 Tokyo
		zombies = 30;
		cities[3] = new City("Tokyoyo", 13000000, zombies, a);
		cities[3].setX(1185);
		cities[3].setY(245);
		
		// city 5 Delhi
		zombies = 2;
		cities[4] = new City("Delhi Mail", 11000000, zombies, a);
		cities[4].setX(950);
		cities[4].setY(260);
		
		// city 6 Sao Paulo
		zombies = 2;
		cities[5] = new City("Sao Paulo", 11000000, zombies, a);
		cities[5].setX(480);
		cities[5].setY(400);
		
		// city 7 Lima
		zombies = 20;
		cities[6] = new City("New Lima", 7600000, zombies, a);
		cities[6].setX(400);
		cities[6].setY(380);
		
		// city 8 Mexico City
		zombies = 2;
		cities[7] = new City("New Mehico City", 11000000, zombies, a);
		cities[7].setX(275);
		cities[7].setY(246);
		
		// city 9 New York
		zombies = 5;
		cities[8] = new City("Not so New York", 19000000, zombies, a);
		cities[8].setX(370);
		cities[8].setY(235);
		
		// city 10 Lagos
		zombies = 200;
		cities[9] = new City("Fort Lagos", 21000000, zombies, a);
		cities[9].setX(670);
		cities[9].setY(314);
		
		// city 11 Cairo
		zombies = 2;
		cities[10] = new City("Fort Cairo", 10000000, zombies, a);
		cities[10].setX(785);
		cities[10].setY(265);
		
		// city 12 Johannesburg
		zombies = 9;
		cities[11] = new City("Johannesburger", 950000, zombies, a);
		cities[11].setX(760);
		cities[11].setY(400);
		
		// city 13 Sydney
		zombies = 1;
		cities[12] = new City("New Sydney", 4000000, zombies, a);
		cities[12].setX(1240);
		cities[12].setY(425);
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

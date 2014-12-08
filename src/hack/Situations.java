package hack;

import java.util.Random;

public class Situations {

	private long dayElapsed;
	private Random rnd;
	private Cities cities;
	private String message;
	private boolean toggleAlert;
	private Money bank;
	private int noEventCount = 0;
	private int maxNoEvents = 2;
	
	public Situations(Cities c, Money m) {

		message = "";
		toggleAlert = false;
		dayElapsed = 0;
		rnd = new Random(3475934587L);
		cities = c;
		bank = m;

	}
	
	public boolean isAlert() {
		
		if (toggleAlert) {
			toggleAlert = false;
			return true;
		} else {
			return false;
		}
		
	}
	
	public String getMessage() {
		
		return this.message;
		
	}

	public void update(long elapsed) {

		dayElapsed += elapsed;
		if (dayElapsed < 18000) {
			return;
		}
		dayElapsed = 0;

		// 50/50 chance of event occuring
		if (rnd.nextInt(6) > 3 || noEventCount == maxNoEvents) {
			noEventCount = 0;
			throwEvent();
		} else {
			System.err.println("No situation.");
			noEventCount++;
		}

	}
	
	private int selectCityID() {
		
		int cityID = -1;
		int iterations = 0;
		
		while (cityID == -1) {
			
			iterations++;
			
			cityID = rnd.nextInt(cities.getNumberOfCities());
			
			if (iterations == 10) break;
			
			// Not dead cities
			if (cities.getCityByIndex(cityID).isDead()) {
				cityID = -1;
			}
			
			// Not severely infect cities
			if (cities.getCityByIndex(cityID).getPercentageOfPopulation() > 50) {
				cityID = -1;
			}
			
		}
		
		return cityID;
		
	}

	private void throwEvent() {

		// Select city
		int cityID = selectCityID();
		String cityName = cities.getCityByIndex(cityID).getCityName();
		System.out.println("Event for " + cityName);

		// Select an event
		int event = rnd.nextInt(6);
		if (event == 0) { // Space zombies have invaded

			int currentZombies = cities.getCityByIndex(cityID)
					.getZombieNumber();
			int people = cities.getCityByIndex(cityID).getPopulation();
			int increase = (int) (0.1f * people); // 10 percent
			cities.getCityByIndex(cityID).setZombieNumber(
					currentZombies + increase);
			message = replaceInString(
					"$CITY has been invaded by \nSPACE ZOMBIES!", "$CITY",
					cityName);
			
		} else if (event == 1) { // Invented soap
			
			int currentZombies = cities.getCityByIndex(cityID).getZombieNumber();
			if (currentZombies > 0) {
			int people = cities.getCityByIndex(cityID).getPopulation();
			int increase = (int) (0.5f * people); // 50 percent
			
			cities.getCityByIndex(cityID).setZombieNumber(currentZombies - increase);
			cities.getCityByIndex(cityID).setPopulation(people + increase);
			}
			message = replaceInString("$CITY has invented soap and used \nit to cure many zombies!", "$CITY", cityName);
			
		} else if (event == 2) { // Increase of zombies
			
			int currentZombies = cities.getCityByIndex(cityID).getZombieNumber();
			int people = cities.getCityByIndex(cityID).getPopulation();
			int increase = (int) (0.5f * people); // 50 percent
			cities.getCityByIndex(cityID).setZombieNumber(currentZombies + increase);
			cities.getCityByIndex(cityID).setPopulation(people - increase);
			message = replaceInString("The zombie plague has taken hold of \n$CITY!", "$CITY", cityName);
			
		} else if (event == 3) { // Increase of zombies 2
			
			int currentZombies = cities.getCityByIndex(cityID).getZombieNumber();
			int people = cities.getCityByIndex(cityID).getPopulation();
			int increase = (int) (0.35f * people); // 50 percent
			cities.getCityByIndex(cityID).setZombieNumber(currentZombies + increase);
			cities.getCityByIndex(cityID).setPopulation(people - increase);
			message = replaceInString("Virus outbreak in $CITY!", "$CITY", cityName);
			
		}  else if (event == 4) { // Missing money
			
			int current = bank.cash;
			int decrease = (int)(0.5f * current);
			bank.Purchase(decrease);
			message = replaceInString("Criminals in $CITY have stolen \nmoney from you!", "$CITY", cityName);
			
		} else if (event == 5) { // change zombie rate
			
			float current = cities.getCityByIndex(cityID).getInfectionRate();
			cities.getCityByIndex(cityID).setInfectionRate(current * 2);
			message = replaceInString("Zombies in $CITY have become \nintelligent!", "$CITY", cityName);
			
		}
		
		toggleAlert = true;

	}

	private String replaceInString(String body, String needle, String exp) {

		return body.replace(needle, exp);

	}

}

package hack;

import java.awt.Point;

public class City {
	private String cityName;
	private Point coordinates;
	private int population;			// in thousands
	private float infectionRate;	// out of hundred
	private int zombies;
	
	final private int maxInfection = 100;  // max infection, elimination
	
	public City(String name, int positionX, int positionY, int population, float infectRate, int zombies){
		cityName = name;
		coordinates.x = positionX;
		coordinates.y = positionY;
		this.population = population;
		infectionRate = infectRate;	
		this.zombies = zombies;
	}
	
	public void increaseInfection(){
		if (infectionRate < maxInfection)
			infectionRate++;
		else
			infectionRate = maxInfection;
	}
	public void increaseInfectionBy(int n){
		if (infectionRate + n <= maxInfection)
			infectionRate += n;
		else
			infectionRate = maxInfection;
	}
	public void decreaseInfection(){
		if (infectionRate >= 0)
			infectionRate--;
		else
			infectionRate = 0;
	}
	public void decreaseInfectionBy(int n){
		if (infectionRate - n >= 0)
			infectionRate -= n;
		else
			infectionRate = 0;
	}
	
	public void updateInfection(){
		int infection = (int) ((int) Math.random() * infectionRate + 1);
		infection = population / maxInfection * infection;
		zombies += infection;
		if (population - infection >= 0)
			population -= infection;
		else
			population = 0;
		
		if (zombies != 0)
			increaseInfection();
	}
	public void eliminatingZombies(int eliminatingRate){
		if (eliminatingRate != maxInfection)
		{
			int elimination = zombies / maxInfection * eliminatingRate;
			if (zombies - elimination >= 0)
				zombies -= elimination;
			else
				zombies = 0;
		}
	}
	public void eliminatingPeople(int eliminatingRate){
		if (eliminatingRate != maxInfection)
		{
			int elimination = population / maxInfection * eliminatingRate;
			if (population - elimination >= 0)
				population -= elimination;
			else
				population = 0;
		}
	}
	
	public Point getCoordinates(){
		return coordinates;
	}
	public int getX(){
		return coordinates.x;
	}
	public void setX(int x){
		coordinates.x = x;
	}
	public int getY(){
		return coordinates.y;
	}
	public void setY(int y){
		coordinates.y = y;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public float getInfectionRate() {
		return infectionRate;
	}

	public void setInfectionRate(float infectionRate) {
		this.infectionRate = infectionRate;
	}

	public int getZombies() {
		return zombies;
	}

	public void setZombies(int zombies) {
		this.zombies = zombies;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}
	
}

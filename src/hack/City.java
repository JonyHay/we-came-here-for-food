package hack;

import game2D.Animation;
import game2D.Sprite;

import java.util.ArrayList;
import java.util.Random;

public class City extends Sprite {
	private String cityName;
	private int population; // in thousands
	private float infectionRate; // out of hundred
	private int zombies;
	private ArrayList<Agent> agents = new ArrayList<Agent>(); 
	private long countup = 0;

	final private int maxInfection = 100; // max infection, elimination

	private int timer = 0;
	final private int maxTimer = 50;
	
	

	public City(String name, int population, int zombies, Animation a) {
		super(a);
		cityName = name;
		this.population = population;
		this.zombies = zombies;
		infectionRate = zombies * 100 / population;
	}

	public void increaseInfection() {
		if (infectionRate < maxInfection)
			infectionRate += 0.25f;
		else
			infectionRate = maxInfection;
	}

	public void increaseInfectionBy(int n) {
		if (infectionRate + n <= maxInfection)
			infectionRate += n;
		else
			infectionRate = maxInfection;
	}

	public void decreaseInfection() {
		if (infectionRate >= 0)
			infectionRate -= 0.25f;
		else
			infectionRate = 0;
	}

	public void decreaseInfectionBy(int n) {
		if (infectionRate - n >= 0)
			infectionRate -= n;
		else
			infectionRate = 0;
	}

	public void updateInfection() {
		if ((zombies > 0) && (timer == maxTimer))
		{
			int infection = (int) ((int) Math.random() * infectionRate + 1);
			infection = population / maxInfection * infection;
			zombies += infection;
			if (population - infection >= 0)
				population -= infection;
			else
				population = 0;
	
			if (zombies != 0)
				increaseInfection();
			

			if (population == maxInfection - 1)
			{
				zombies += population - 1;
				population = 0;
			}
			
			timer = 0;
		}
		else if (timer < maxTimer)
			timer++;
	}
	

	public void addAgents(ArrayList<Agent> a) {
		if (a.size() != 0) {
			for (int i = 0; i < a.size(); i++) {
				agents.add(a.get(i));
			}
		}
	}

	public void updateAgents(long elapsed)
    {
        countup += elapsed;
        if (countup < 24000)
        {
                return;
        }
        for(int i = 0; i < agents.size(); i++)
        {
                Random r =  new Random();
                int infectedPercent = zombies/population*100;
                if (r.nextInt(infectedPercent) > ((r.nextInt(infectedPercent) + agents.get(i).getBonusDefence() + agents.get(i).getSpeciality().getDefence())))
                {
                        agents.remove(i);
                        i--;
                }
                int zombieReduction = (r.nextInt(zombies) + agents.get(i).getBonusOffence() + agents.get(i).getSpeciality().getOffence())/2;
                if (zombieReduction < zombies)
                {
                        zombies = zombies - zombieReduction;
                }
                int zombiesHealed = (r.nextInt(zombies) + agents.get(i).getBonusHealing() + agents.get(i).getSpeciality().getHealing())/4;
                if (zombiesHealed < zombies)
                {
                        zombies = zombies - zombiesHealed;
                        population = population + zombiesHealed;
                }
        }
        countup = 0;
    }

	public int getPercentageOfPopulation() {
		int total = zombies + population;
		return (int) (population / 100 * total);
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

	public int getZombieNumber() {
		return zombies;
	}

	public void setZombieNumber(int zombies) {
		this.zombies = zombies;
	}

}
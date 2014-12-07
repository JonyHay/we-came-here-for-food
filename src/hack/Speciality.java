package hack;

public class Speciality 
{
	private String name;
	private int offence;
	private int defence;
	private int healing;
	
	public Speciality(String name, int offence, int defence, int healing)
	{
		this.name = name;
		this.offence = offence;
		this.defence = defence;
		this.healing = healing;
	}

	public String getName() 
	{
		return name;
	}

	public int getOffence() 
	{
		return offence;
	}

	public void addOffence(int offence) 
	{
		this.offence += offence;
	}

	public int getDefence() 
	{
		return defence;
	}

	public void addDefence(int defence) 
	{
		this.defence += defence;
	}

	public int getHealing() 
	{
		return healing;
	}

	public void addHealing(int healing) 
	{
		this.healing += healing;
	}
}

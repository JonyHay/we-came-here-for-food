
public class Upgrade 
{
	private int cost;
	private String name;
	private String description;
	
	public Upgrade(int cost, String name, String description)
	{
		this.cost = cost;
		this.name = name;
		this.description = description;
	}
	public int getCost() 
	{
		return cost;
	}

	public String getName() 
	{
		return name;
	}

	public String getDescription() 
	{
		return description;
	}
	
	public void applyAgentUpgrade(int offence, int defence, int healing, Agent agent)
	{
		agent.addBonusOffence(offence);
		agent.addBonusDefence(defence);
		agent.addBonusHealing(healing);
	}
	
	public void applySpecialityUpgrade(int offence, int defence, int healing, Speciality speciality)
	{
		speciality.addOffence(offence);
		speciality.addDefence(defence);
		speciality.addHealing(healing);
	}
	
}

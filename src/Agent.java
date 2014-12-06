import java.util.ArrayList;

public class Agent 
{
	private int agentID;
	private String foreName;
	//private String surName;
	//private boolean gender;
	//private int experienceTotal;
	private String status;
	private Speciality speciality;
	private int bonusOffence;
	private int bonusDefence;
	private int bonusHealing;
	
	public Agent(int agentID, String foreName, Speciality speciality)
	{
		this.agentID = agentID;
		this.foreName = foreName;
		this.speciality = speciality;
		bonusOffence = 0;
		bonusDefence = 0;
		bonusHealing = 0;
	}
	
	public void update(int hours)
	{
		
	}

	public int getAgentID() 
	{
		return agentID;
	}

	public String getForeName() 
	{
		return foreName;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public Speciality getSpeciality() 
	{
		return speciality;
	}

	public void setSpeciality(Speciality speciality) 
	{
		this.speciality = speciality;
	}

	public int getBonusOffence() {
		return bonusOffence;
	}

	public void addBonusOffence(int bonusOffence) {
		this.bonusOffence += bonusOffence;
	}

	public int getBonusDefence() {
		return bonusDefence;
	}

	public void addBonusDefence(int bonusDefence) {
		this.bonusDefence += bonusDefence;
	}

	public int getBonusHealing() {
		return bonusHealing;
	}

	public void addBonusHealing(int bonusHealing) {
		this.bonusHealing += bonusHealing;
	}
}

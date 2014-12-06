import java.util.ArrayList;

public class Agent 
{
	private int agentID;
	private String foreName;
	//private String surName;
	//private boolean gender;
	//private int experience;
	private ArrayList<String> upgradesBought;
	private String status;
	private String speciality;
	
	public Agent(int agentID, String foreName, String speciality)
	{
		this.agentID = agentID;
		this.foreName = foreName;
		this.speciality = speciality;
	}

	public int getAgentID() 
	{
		return agentID;
	}

	public String getForeName() 
	{
		return foreName;
	}

	public ArrayList<String> getUpgradesBought() 
	{
		return upgradesBought;
	}
	
	public void addUpgradesBought(String upgrade) 
	{
		upgradesBought.add(upgrade);
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getSpeciality() 
	{
		return speciality;
	}

	public void setSpeciality(String speciality) 
	{
		this.speciality = speciality;
	}
}

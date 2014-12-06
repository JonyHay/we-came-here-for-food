import java.util.ArrayList;

public class AgentHandler 
{
	private ArrayList<Agent> agentList;
	
	public AgentHandler()
	{
		
	}
	
	public ArrayList<Agent> getAgentList()
	{
		return agentList;
	}
	
	public void addAgent(Agent agent)
	{
		agentList.add(agent);
	}
}

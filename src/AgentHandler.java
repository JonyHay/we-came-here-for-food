import java.util.ArrayList;

public class AgentHandler 
{
	private ArrayList<Agent> agentList;
	
	public AgentHandler()
	{
		//nothing here yet
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

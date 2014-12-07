package hack;

import java.util.ArrayList;
import java.util.Random;

public class AgentHandler {
	private ArrayList<Agent> agentList;
	private ArrayList<Speciality> agentClasses;
	private Speciality offenceClass;
	private Speciality defenceClass;
	private Speciality medicClass;
	private Upgrade betterMedKits;
	private Upgrade bigGuns;
	private Upgrade cyberneticImplants;
	private int i = 0;

	public AgentHandler() {

		agentList = new ArrayList<Agent>();

		offenceClass = new Speciality("Offence", 30, 10, 10);
		defenceClass = new Speciality("Defence", 10, 30, 10);
		medicClass = new Speciality("Medic", 10, 10, 30);
		betterMedKits = new Upgrade(
				100,
				"Better Med-Kits",
				"Buys better medical supplies for your medics to use. Improves medic skill by 10");
		bigGuns = new Upgrade(75, "Big Guns!",
				"Buys bigger guns for all your troops. Improves offence by 5.");
		cyberneticImplants = new Upgrade(
				50,
				"Cybernetic Implants",
				"Gives a single agent cybernetic implants. Improves offence by 20 and defence by 10");

		populateAgents();
	}

	public ArrayList<Agent> getAgentList() {
		return agentList;
	}

	public void addAgent(Agent agent) {
		agentList.add(agent);
	}

	public String getRandomForeName() {
		Random r = new Random();
		String[] foreNames = { "Jony", "Daniel", "Han", "Skaiste", "Martynas" };
		return foreNames[r.nextInt(foreNames.length)];
	}

	public void populateAgents() {
		for (int j = 0; j < 7; j++) {
			Random r = new Random();
			int result = r.nextInt(3);
			if (result == 0) {
				addMedicAgent();
			}
			if (result == 1) {
				addDefenceAgent();
			}
			if (result == 2) {
				addOffenceAgent();
			}
		}
		addMedicAgent();
		addOffenceAgent();
		addDefenceAgent();
	}

	public void addMedicAgent() {
		Agent newAgent = new Agent(i, getRandomForeName(), medicClass);
		agentList.add(newAgent);
		i++;
	}

	public void addDefenceAgent() {
		Agent newAgent = new Agent(i, getRandomForeName(), defenceClass);
		agentList.add(newAgent);
		i++;
	}

	public void addOffenceAgent() {
		Agent newAgent = new Agent(i, getRandomForeName(), offenceClass);
		agentList.add(newAgent);
		i++;
	}

	public void buyUpgrade(String upgradeName) {
		if (upgradeName.equals("Better Med-Kits")) {
			medicClass.addHealing(10);
		}
		if (upgradeName.equals("Big Guns!")) {
			medicClass.addOffence(5);
			defenceClass.addOffence(5);
			offenceClass.addOffence(5);
		}
	}

	public void buyUpgrade(String upgradeName, int agentID) {
		if (upgradeName.equals("Cybernetic Implants")) {
			medicClass.addHealing(10);
		}
		for (int j = 0; j < 15; j++) {
			if (agentList.get(j).getAgentID() == agentID) {
				agentList.get(j).addBonusOffence(20);
				agentList.get(j).addBonusDefence(10);
			}
		}
	}

	public Agent removeAgent(int agentID) {
		int j = 0;
		for (; j < 15; j++) {
			if (agentList.get(j).getAgentID() == agentID) {
				break;
			}
		}
		return agentList.remove(j);
	}

	public void returnAgent(Agent agent) {
		agentList.add(agent);
	}

}

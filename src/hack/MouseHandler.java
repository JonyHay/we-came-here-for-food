package hack;

import game2D.Sound;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class MouseHandler implements MouseListener {

	private Cities cities;
	private int selectedCity;
	private ArrayList<Ring> rings;
	private Game tg;
	private AgentHandler agentHandler;

	public MouseHandler(Cities c, ArrayList<Ring> r, Game a, AgentHandler agents) {

		selectedCity = -1;
		cities = c;
		rings = r;
		tg = a;
		this.agentHandler = agents;

	}

	public void resetReferenceToRings(ArrayList<Ring> r) {

		this.rings = r;

	}

	public int getSelectedCityIndex() {

		return selectedCity;

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println("*Clicked at " + e.getX() + "/" + e.getY());
		int rnd = new Random().nextInt(3);
		new Sound("res/blim" + rnd + ".wav").start();

		if (tg.alertMode) {

			tg.alertMode = false;

		} else {

			int cityCount = cities.getNumberOfCities();

			// Calculate closest
			if (e.getY() < 595) {
				rings.add(new Ring(e.getX(), e.getY()));
				selectedCity = -1;
				float nearestDistance = 25000.0f;

				for (int i = 0; i < cityCount; i++) {

					City city = cities.getCityByIndex(i);
					float distance = calculateDistance((int) city.getX(),
							(int) city.getY(), e.getX(), e.getY());

					if (distance < 0)
						distance = distance * (-1);

					if (distance < nearestDistance && distance < 40) {
						selectedCity = i;
						nearestDistance = distance;
					}

				}

				System.out.println("*Selected " + selectedCity);
			} // FINISH CALCULATE ON MAP ACTIONS
			else {

				doClickOnAgents(e);
				doClickOnPurchase(e);
				
			}

		}

	}
	
	private void doClickOnPurchase(MouseEvent e) {
		
		if ((e.getX() >= 1039 && e.getX() < 1235) && (e.getY() >= 609 && e.getY() < 643)) {
			if (agentHandler.getAgentList().size() < 15) {
				if (tg.getBank().Purchase(8000))
					agentHandler.addOffenceAgent();
			}
		}
		
		if ((e.getX() >= 1038 && e.getX() < 1235) && (e.getY() >= 644 && e.getY() < 676)) {
			if (agentHandler.getAgentList().size() < 15)
				if (tg.getBank().Purchase(6000))
						agentHandler.addDefenceAgent();
		}
		
		if ((e.getX() >= 1038 && e.getX() < 1235) && (e.getY() >= 677 && e.getY() < 707)) {
			if (agentHandler.getAgentList().size() < 15)
				if (tg.getBank().Purchase(7000))
						agentHandler.addMedicAgent();
		}
		
		// BELOW THIS IS UPGRADES
		
		if ((e.getX() >= 1267 && e.getX() < 1326) && (e.getY() >= 609 && e.getY() < 643)) {
			if (tg.getBank().Purchase(50000))
				agentHandler.buyUpgrade("Better Med-Kits");
		}
		
		if ((e.getX() >= 1267 && e.getX() < 1326) && (e.getY() >= 644 && e.getY() < 676)) {
			if (tg.getBank().Purchase(50000))
				agentHandler.buyUpgrade("Big Guns!");
		}
		
		if ((e.getX() >= 1267 && e.getX() < 1326) && (e.getY() >= 677 && e.getY() < 707)) {
			//agentHandler.buyUpgrade("Better Med-Kits");
		}
		
	}
	

	private void doClickOnAgents(MouseEvent e) {
		
		if (this.getSelectedCityIndex() == -1) {
			System.out.println("No active city.");
			return;
		}

		// Work out which region was clicked

		// City region
		if ((e.getX() >= 480 && e.getX() < 725)
				&& (e.getY() > 608 && e.getY() < 707)) {
			System.out.println("Click in city region.");

			// Get the agents
			ArrayList<Agent> agents = cities.getCityByIndex(getSelectedCityIndex()).getAgents();

			int row = 0, i = 0, iconsize = 28;

			ListIterator<Agent> li = agents.listIterator();
			while (li.hasNext()) {

				Agent a = li.next();
				
				//g.fillRect(487 + ((iconsize + 21) * i), 607 + ((iconsize + 5) * row), 32, 32);

				int x1 = 487 + ((iconsize + 21) * i), x2 = (487 + ((iconsize + 21) * i)) + 32;
				int y1 = 607 + ((iconsize + 5) * row), y2 = 607 + ((iconsize + 5) * row) + 32;

				// Collides!
				if ((e.getX() >= x1 && e.getX() < x2)
						&& (e.getY() >= y1 && e.getY() < y2)) {

					
					if (agentHandler.getAgentList().size() < 15) {
						
						tg.addAgent(a);
						cities.getCityByIndex(getSelectedCityIndex()).removeAgent(a.getAgentID());
				
					}

					break;
				}

				if (++i == 5) {
					i = 0;
					row++;
				}

			}

			return;
		}

		// Player region
		if ((e.getX() >= 759 && e.getX() < 1008)
				&& (e.getY() > 609 && e.getY() < 705)) {
			System.out.println("Click in player region.");

			// Get the agents
			ArrayList<Agent> agents = agentHandler.getAgentList();

			int row = 0, i = 0, iconsize = 28;

			ListIterator<Agent> li = agents.listIterator();
			while (li.hasNext()) {

				Agent a = li.next();

				int x1 = 767 + ((iconsize + 21) * i), x2 = (767 + ((iconsize + 21) * i)) + 32;
				int y1 = 607 + ((iconsize + 5) * row), y2 = 607 + ((iconsize + 5) * row) + 32;

				// Colides!
				if ((e.getX() >= x1 && e.getX() < x2)
						&& (e.getY() >= y1 && e.getY() < y2)) {

					if (cities.getCityByIndex(getSelectedCityIndex()).getAgents().size() < 15) {
						cities.getCityByIndex(getSelectedCityIndex()).addAgent(a);
						agentHandler.removeAgent(a.getAgentID());
					}

					break;
				}

				if (++i == 5) {
					i = 0;
					row++;
				}

			}

			return;
		}

	}

	private float calculateDistance(int x1, int y1, int x2, int y2) {

		return (float) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

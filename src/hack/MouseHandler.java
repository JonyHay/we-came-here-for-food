package hack;

import game2D.Sound;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class MouseHandler implements MouseListener {
	
	private Cities cities;
	private int selectedCity;
	private ArrayList<Ring> rings;
	private Game tg;
	
	public MouseHandler(Cities c, ArrayList<Ring> r, Game a) {
		
		selectedCity = -1;
		cities = c;
		rings = r;
		tg = a;
		
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
					float distance = calculateDistance((int)city.getX(), (int)city.getY(), e.getX(), e.getY());
					
					if (distance < 0) distance = distance * (-1);
					
					if (distance < nearestDistance && distance < 40) {
						selectedCity = i;
						nearestDistance = distance;
					}
					
				}
				
				System.out.println("*Selected " + selectedCity);
			}
			
		}
		
	}
	
	private float calculateDistance(int x1, int y1, int x2, int y2) {
		
		return (float) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		
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

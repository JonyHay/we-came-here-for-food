package hack;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
	
	private Cities cities;
	private int selectedCity;
	
	public MouseHandler(Cities c) {
		
		selectedCity = -1;
		cities = c;
		
	}

	public int getSelectedCityIndex() {
		
		return selectedCity;
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("*Clicked at " + e.getX() + "/" + e.getY());
		
		int cityCount = cities.getNumberOfCities();
		
		// Calculate closest
		if (e.getY() < 595) {
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

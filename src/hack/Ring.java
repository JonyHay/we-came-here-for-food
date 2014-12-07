package hack;

import java.awt.Color;
import java.awt.Graphics2D;

public class Ring {

	private int x, y;
	private long life;
	
	public Ring(int x, int y) {
		
		this.x = x;
		this.y = y;
		life = 0;
		
	}
	
	public boolean expired() {
		
		return life > 10000;
		
	}
	
	public void update(long elapsed) {
		
		life+= elapsed;
		
	}
	
	private int radius() {
		
		return (int)(life / 10);
		
	}
	
	public void draw(Graphics2D g) {
		
		int radius = radius();
		
		g.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
		
		g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
		
	}
	
}

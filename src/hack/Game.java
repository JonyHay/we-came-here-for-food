package hack;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import game2D.Animation;
import game2D.GameCore;
import game2D.Sprite;
import game2D.BadCloser;

@SuppressWarnings("serial")
public class Game extends GameCore {
	
	private static 	Animation	gameBackground;
	private static 	Sprite 		wMap;
	private static 	Game 		game;	
	private static 	int 		hpMax = 150;
	private 		int			hp;
	private 		Color 		hpColor;

	public static void main(String[] args) 
	{ 
		game = new Game();
		game.addWindowListener(new BadCloser());
		game.init();
		game.run(false, 1365, 730); // need to generalise screen pixels for any given monitor
	}
	
	public void init()
	{
		gameBackground = new Animation();
		gameBackground.addFrame(Toolkit.getDefaultToolkit().createImage("res/wMap.png"), 10);
		wMap = new Sprite(gameBackground);
		hp = hpMax;
		hpColor = Color.GREEN;
	}
	
	public void update(long elapsed)
	{
		hp = hp - (int) (elapsed * 0.1);
		if (hp < hpMax/3)
		{
			hpColor = Color.red;
		}
//		try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
		
	}

	@Override
	public void draw(Graphics2D g) 
	{
		// Refresher
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 10000, 10000);
		
		// Map
		g.drawImage(gameBackground.getImage(), 10, 90, wMap.getWidth(), wMap.getHeight(), this); //need to generalise screen pixels for any given monitor	
				
		// Money
		g.setColor(Color.BLACK);
		g.drawString("Money", 110, 78);
		g.drawRect(50, 58, 150, 30);
		
		// Time
		g.setColor(Color.BLACK);
		g.drawString("Time", 650, 78);
		g.drawRect(590, 50, 150, 50);
		
		// HP
		g.setColor(Color.BLACK);
		g.drawRect(1150, 58, hpMax, 30);
		g.setColor(hpColor);
		g.fillRect(1150, 58, hp, 30);
		
		// City 1
		g.setColor(Color.GREEN);
		g.drawOval(95, 270, 20, 20);
		
		System.out.println("draw");
		
		// g.updated automatically called here	
	}
}

//SwingUtilities.invokeLater(new Runnable() {
//
//@Override
//public void run() {
//	// TODO Auto-generated method stub
//	
//}
//});

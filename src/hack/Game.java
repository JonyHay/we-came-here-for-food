package hack;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import game2D.Animation;
import game2D.GameCore;
import game2D.Sound;
import game2D.Sprite;
import game2D.BadCloser;

@SuppressWarnings("serial")
public class Game extends GameCore {
	
	private static 	Animation	wMapAni, tThemeAni, bThemeAni, cityGreenAni, cityYellowAni, cityRedAni;
	private static 	Sprite 		wMap, tTheme, bTheme, cityGreen, cityYellow, cityRed;
	private static 	Game 		game;	
	
	private static 	int 		gameWindowX, gameWindowY;
	
	private static	String 		mapName; 
	private static	int 		mapOffsetX, mapOffsetY, mapSizeX, mapSizeY;
	
	private static String 		themeName;
	private 		int 		tThemeOffsetX, tThemeSizeX;
	private static	int 		tThemeSizeY, tThemeOffsetY, tThemeOffsetXInit, tThemeSizeXInit;
	private 		int 		bThemeOffsetX, bThemeSizeX;
	private static	int 		bThemeSizeY, bThemeOffsetY, bThemeOffsetXInit, bThemeSizeXInit;
	
	private static	Color 		moneyColor; 
	private static	int 		moneyOffsetX, moneyOffsetY;
	private static	int 		moneyBoxOffsetX, moneyBoxOffsetY, moneyBoxSizeX, moneyBoxSizeY, moneyBoxArcX, moneyBoxArcY;
	
	private	static	Color 		timeColor;
	private static	int 		timeOffsetX, timeOffsetY;
	private static	int 		timeBoxOffsetX, timeBoxOffsetY, timeBoxSizeX, timeBoxSizeY, timeBoxArcX, timeBoxArcY;
	
	private static	Color 		hpColor, hpBoxColor; 
	private static	int 		hpBoxOffsetX, hpBoxOffsetY, /*colorBoxSizeX = hp*/ hpBoxSizeY, hpBoxArcX, hpBoxArcY;
	private static 	int 		hpMax;
	private 		int			hp;
	
//	private static String 		cityGreenName, cityYellowName, cityRedName;
//	private static int 			citySizeX, citySizeY;
//	private static int 			city1OffsetX, city1OffsetY, city2OffsetX, city2OffsetY, city3OffsetX, city3OffsetY, 
//								city4OffsetX, city4OffsetY, city5OffsetX, city5OffsetY, city6OffsetX, city6OffsetY,
//								city7OffsetX, city7OffsetY, city8OffsetX, city8OffsetY, city9OffsetX, city9OffsetY;
	
	private static Color		botBoxColor;
	private static int 			botLeftBoxOffsetX, botLeftBoxOffsetY, botLeftBoxSizeX, botLeftBoxSizeY, botLeftBoxArcX, botLeftBoxArcY;
	private static int 			botMidBoxOffsetX, botMidBoxOffsetY, botMidBoxSizeX, botMidBoxSizeY, botMidBoxArcX, botMidBoxArcY;
	private static int 			botRightBoxOffsetX, botRightBoxOffsetY, botRightBoxSizeX, botRightBoxSizeY, botRightBoxArcX, botRightBoxArcY;
							
	private Color transpColor;
	
	private Image fadeLine;
	
	private Cities cities;
	private AgentHandler agentHandler;

	public static void main(String[] args) 
	{ 
		game = new Game();
		game.addWindowListener(new BadCloser());
		game.init();
		game.run(false, gameWindowX, gameWindowY); // need to generalise screen pixels for any given monitor
	}
	
	public void init()
	{
		
		Sound s = new Sound("res/music.wav");
		s.start();
		
		cities = new Cities();
		agentHandler = new AgentHandler();
		
		transpColor = new Color(0, 0, 0, 0.5f);
		
		fadeLine = Toolkit.getDefaultToolkit().createImage("res/line.png");
		
		wMapAni 			= new Animation();
		tThemeAni 			= new Animation();
		bThemeAni 			= new Animation();
		cityGreenAni 		= new Animation();
		cityYellowAni 		= new Animation();
		cityRedAni 			= new Animation();
		
		mapName 			= "res/wMap.jpg";
//		mapName 			= "res/wMap.png"; 
		themeName 			= "res/theme.jpg";
//		cityGreenName 		= "res/green.png";
//		cityYellowName 		= "res/yellow.png";
//		cityRedName 		= "res/red.png";
		
		wMapAni.addFrame(Toolkit.getDefaultToolkit().createImage(mapName), 10); // 10 is just a filler number
		tThemeAni.addFrame(Toolkit.getDefaultToolkit().createImage(themeName), 10);
		bThemeAni.addFrame(Toolkit.getDefaultToolkit().createImage(themeName), 10);
//		cityGreenAni.addFrame(Toolkit.getDefaultToolkit().createImage(cityGreenName), 10);
//		cityYellowAni.addFrame(Toolkit.getDefaultToolkit().createImage(cityYellowName), 10);
//		cityRedAni.addFrame(Toolkit.getDefaultToolkit().createImage(cityRedName), 10);
		
		wMap 				= new Sprite(wMapAni);
		tTheme 				= new Sprite(tThemeAni);
		bTheme	 			= new Sprite(bThemeAni);
//		cityGreen 			= new Sprite(cityGreenAni);
//		cityYellow 			= new Sprite(cityYellowAni);
//		cityRed				= new Sprite(cityRedAni);
		
		gameWindowX 		= 1365; 
		gameWindowY 		= 730;
		
		mapOffsetX 			= 8; 
		mapOffsetY 			= 110; 
		mapSizeX 			= 1349; 
		mapSizeY 			= 480;
		
		tThemeOffsetX 		= 8;
		tThemeOffsetXInit 	= tThemeOffsetX;
		tThemeOffsetY 		= 30;
		tThemeSizeX 		= 80;	
		tThemeSizeXInit 	= tThemeSizeX;
		tThemeSizeY 		= 80;
		
		bThemeOffsetX 		= 8;
		bThemeOffsetXInit 	= bThemeOffsetX;
		bThemeOffsetY 		= 590;
		bThemeSizeX 		= 132;	
		bThemeSizeXInit 	= bThemeSizeX;
		bThemeSizeY 		= 132;
		
		moneyColor 			= Color.BLACK; 
		moneyOffsetX 		= 110; 
		moneyOffsetY 		= 78;
		moneyBoxOffsetX 	= 50; 
		moneyBoxOffsetY 	= 58; 
		moneyBoxSizeX 		= 150; 
		moneyBoxSizeY 		= 30;
		moneyBoxArcX 		= 20;
		moneyBoxArcY  		= 20;
		
		timeColor 			= Color.BLACK;
		timeOffsetX 		= 650; 
		timeOffsetY 		= 78;
		timeBoxOffsetX 		= 590; 
		timeBoxOffsetY 		= 50; 
		timeBoxSizeX 		= 150; 
		timeBoxSizeY 		= 50;
		timeBoxArcX 		= 20;
		timeBoxArcY  		= 20;
		
		hpColor 			= Color.GREEN; 
		hpBoxColor 			= Color.BLACK;
		hpBoxOffsetX 		= 1150; 
		hpBoxOffsetY 		= 58; 
		/*colorBoxSizeX 	= hp*/ 
		hpBoxSizeY 			= 30;
		hpBoxArcX 			= 20;
		hpBoxArcY  			= 20;
		hpMax 				= 150;
		hp 					= hpMax;
		
//		citySizeX 			= 20;
//		citySizeY 			= 20;
//		
//		city1OffsetX 		= 280;
//		city1OffsetY 		= 240;
		
		botBoxColor 		= Color.BLACK;
		botLeftBoxOffsetX 	= 30;
		botLeftBoxOffsetY 	= 605;
		botLeftBoxSizeX 	= 415;
		botLeftBoxSizeY 	= 100;
		botLeftBoxArcX  	= 20;
		botLeftBoxArcY 		= 20;
		
		botMidBoxOffsetX 	= botLeftBoxOffsetX + botLeftBoxSizeX + 30;
		botMidBoxOffsetY 	= botLeftBoxOffsetY;
		botMidBoxSizeX 		= botLeftBoxSizeX;
		botMidBoxSizeY 		= botLeftBoxSizeY;
		botMidBoxArcX	 	= 20;
		botMidBoxArcY  		= 20;

		botRightBoxOffsetX 	= botMidBoxOffsetX + botMidBoxSizeX + 30;
		botRightBoxOffsetY 	= botMidBoxOffsetY;
		botRightBoxSizeX 	= botMidBoxSizeX;
		botRightBoxSizeY 	= botMidBoxSizeY;
		botRightBoxArcX	 	= 20;
		botRightBoxArcY  	= 20;

	}
	
	public void updatetTheme(Graphics2D g)
	{
		for (int i = 0; i < 50; i++)
		{
			g.drawImage(tThemeAni.getImage(), tThemeOffsetX, tThemeOffsetY, tThemeSizeX, tThemeSizeY, this);
			tThemeOffsetX = tThemeOffsetX + tThemeSizeX;			
		}
		tThemeOffsetX = tThemeOffsetXInit;
		tThemeSizeX = tThemeSizeXInit;
	}
	
	public void updatebTheme(Graphics2D g)
	{
		for (int i = 0; i < 50; i++)
		{
			g.drawImage(bThemeAni.getImage(), bThemeOffsetX, bThemeOffsetY, bThemeSizeX, bThemeSizeY, this);
			bThemeOffsetX = bThemeOffsetX + bThemeSizeX;			
		}
		bThemeOffsetX = bThemeOffsetXInit;
		bThemeSizeX = bThemeSizeXInit;
	}

	public void update(long elapsed) {
		
		int cityCount = cities.getNumberOfCities();
		int people = 0;
		int zombies = 0;
		
		// Update each city
		for (int i = 0; i < cityCount; i++) {
			
			City c = cities.getCityByIndex(i);
			c.update(elapsed);
			c.updateInfection();
			c.updateAgents(elapsed);
			
			people += c.getPopulation();
			zombies += c.getZombieNumber();
			
			float cityHealth = (float) c.getZombieNumber() / (float) c.getPopulation();
			c.setAnimation(cities.animations[0]);
			if (cityHealth > 0.2f) {
				c.setAnimation(cities.animations[1]);
			}
			if (cityHealth > 0.6f) {
				c.setAnimation(cities.animations[2]);
			}
			
		}
		
		float health = (float) zombies / (float) people;
		hp = hpMax - (int) health;

	}

	public void draw(Graphics2D g) 
	{		
		// Map
		g.drawImage(wMapAni.getImage(), mapOffsetX, mapOffsetY, mapSizeX, mapSizeY, this); //need to generalise screen pixels for any given monitor	
						
		// Top Theme
		updatetTheme(g);
		
		// Time
		g.setColor(transpColor);
		g.fillRoundRect(timeBoxOffsetX, timeBoxOffsetY, timeBoxSizeX, timeBoxSizeY, timeBoxArcX, timeBoxArcY);
		g.setColor(timeColor);
		g.drawString("Time", timeOffsetX, timeOffsetY);
		g.drawRoundRect(timeBoxOffsetX, timeBoxOffsetY, timeBoxSizeX, timeBoxSizeY, timeBoxArcX, timeBoxArcY);
		g.drawRoundRect(timeBoxOffsetX + 1, timeBoxOffsetY + 1, timeBoxSizeX - 2, timeBoxSizeY - 2, timeBoxArcX, timeBoxArcY);
		g.drawRoundRect(timeBoxOffsetX + 2, timeBoxOffsetY + 2, timeBoxSizeX - 4, timeBoxSizeY - 4, timeBoxArcX, timeBoxArcY);
				
		// Money
		g.setColor(transpColor);
		g.fillRoundRect(moneyBoxOffsetX, moneyBoxOffsetY, moneyBoxSizeX, moneyBoxSizeY, moneyBoxArcX, moneyBoxArcY);
		g.setColor(moneyColor);
		g.drawString("Money", moneyOffsetX, moneyOffsetY);
		g.drawRoundRect(moneyBoxOffsetX, moneyBoxOffsetY, moneyBoxSizeX, moneyBoxSizeY, moneyBoxArcX, moneyBoxArcY);
		g.drawRoundRect(moneyBoxOffsetX + 1, moneyBoxOffsetY + 1, moneyBoxSizeX - 2, moneyBoxSizeY - 2, moneyBoxArcX, moneyBoxArcY);
		g.drawRoundRect(moneyBoxOffsetX + 2, moneyBoxOffsetY + 2, moneyBoxSizeX - 4, moneyBoxSizeY - 4, moneyBoxArcX, moneyBoxArcY);
		
		// HP
		g.setColor(Color.BLACK);
		g.fillRoundRect(hpBoxOffsetX, hpBoxOffsetY, hpMax, hpBoxSizeY, hpBoxArcX, hpBoxArcY);
		g.setColor(hpBoxColor);
		g.drawRoundRect(hpBoxOffsetX, hpBoxOffsetY, hpMax, hpBoxSizeY, hpBoxArcX, hpBoxArcY);
		g.drawRoundRect(hpBoxOffsetX + 1, hpBoxOffsetY + 1, hpMax - 2, hpBoxSizeY - 2, hpBoxArcX, hpBoxArcY);
		g.drawRoundRect(hpBoxOffsetX + 2, hpBoxOffsetY + 2, hpMax - 4, hpBoxSizeY - 4, hpBoxArcX, hpBoxArcY);
		g.setColor(hpColor);
		g.fillRoundRect(hpBoxOffsetX + 3, hpBoxOffsetY + 3, hp - 6, hpBoxSizeY - 5, hpBoxArcX, hpBoxArcY);

		// Bot Theme
		updatebTheme(g);
		
//		// City 1
//		g.drawImage(cityGreenAni.getImage(), city1OffsetX, city1OffsetY, citySizeX, citySizeY, this);
		
		// BotLeft Box
		g.setColor(transpColor);
		g.fillRoundRect(botLeftBoxOffsetX, botLeftBoxOffsetY, botLeftBoxSizeX, botLeftBoxSizeY, botLeftBoxArcX, botLeftBoxArcY);
		g.setColor(botBoxColor);
//		g.drawString("Left Box", botLeftBoxOffsetX, botLeftBoxOffsetY);
		g.drawRoundRect(botLeftBoxOffsetX, botLeftBoxOffsetY, botLeftBoxSizeX, botLeftBoxSizeY, botLeftBoxArcX, botLeftBoxArcY);
		g.drawRoundRect(botLeftBoxOffsetX + 1, botLeftBoxOffsetY + 1, botLeftBoxSizeX - 2, botLeftBoxSizeY - 2, botLeftBoxArcX, botLeftBoxArcY);
		g.drawRoundRect(botLeftBoxOffsetX + 2, botLeftBoxOffsetY + 2, botLeftBoxSizeX - 4, botLeftBoxSizeY - 4, botLeftBoxArcX, botLeftBoxArcY);
		
		// BotMid Box
		g.setColor(transpColor);
		g.fillRoundRect(botMidBoxOffsetX, botMidBoxOffsetY, botMidBoxSizeX, botMidBoxSizeY, botMidBoxArcX, botMidBoxArcY);
		g.setColor(botBoxColor);
		g.drawRoundRect(botMidBoxOffsetX, botMidBoxOffsetY, botMidBoxSizeX, botMidBoxSizeY, botMidBoxArcX, botMidBoxArcY);
		g.drawRoundRect(botMidBoxOffsetX + 1, botMidBoxOffsetY + 1, botMidBoxSizeX - 2, botMidBoxSizeY - 2, botMidBoxArcX, botMidBoxArcY);
		g.drawRoundRect(botMidBoxOffsetX + 2, botMidBoxOffsetY + 2, botMidBoxSizeX - 4, botMidBoxSizeY - 4, botMidBoxArcX, botMidBoxArcY);
		
		// BotRight Box
		g.setColor(transpColor);
		g.fillRoundRect(botRightBoxOffsetX, botRightBoxOffsetY, botRightBoxSizeX, botRightBoxSizeY, botRightBoxArcX, botRightBoxArcY);
		g.setColor(botBoxColor);
		g.drawRoundRect(botRightBoxOffsetX, botRightBoxOffsetY, botRightBoxSizeX, botRightBoxSizeY, botRightBoxArcX, botRightBoxArcY);
		g.drawRoundRect(botRightBoxOffsetX + 1, botRightBoxOffsetY + 1, botRightBoxSizeX - 2, botRightBoxSizeY - 2, botRightBoxArcX, botRightBoxArcY);
		g.drawRoundRect(botRightBoxOffsetX + 2, botRightBoxOffsetY + 2, botRightBoxSizeX - 4, botRightBoxSizeY - 4, botRightBoxArcX, botRightBoxArcY);
		
		g.drawImage(fadeLine, 0, mapOffsetY - 1, 1400, 20, this);
		g.drawImage(fadeLine, 0, mapOffsetY - 1, 1400, -3, this);
		g.drawImage(fadeLine, 0, mapOffsetY + mapSizeY + 1, 1400, -20, this);
		g.drawImage(fadeLine, 0, mapOffsetY + mapSizeY + 1, 1400, 3, this);
		
		
		drawCityIcons(g);
		
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 1400, 30);
		g.fillRect(0, 722, 1400, 30);
		g.fillRect(0, 0, 8, 1000);
		g.fillRect(1357, 0, 8, 1000);
		

		// g.updated automatically called here	
	}
	
	private void drawCityIcons(Graphics2D g) {
		
		int cityCount = cities.getNumberOfCities();
		for (int i = 0; i < cityCount; i++) {
			
			City c = cities.getCityByIndex(i);
			g.drawImage(c.getImage(), (int)c.getX(), (int)c.getY(), c.getWidth(), c.getHeight(), this); 
			
		}
		
	}
	
}
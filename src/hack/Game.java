package hack;

import java.awt.Color;
import java.awt.Font;
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
	
	private static 	Color		botBoxColor;
	private static 	int 		botLeftBoxOffsetX, botLeftBoxOffsetY, botLeftBoxSizeX, botLeftBoxSizeY, botLeftBoxArcX, botLeftBoxArcY;
	private static 	int 		botMidBoxOffsetX, botMidBoxOffsetY, botMidBoxSizeX, botMidBoxSizeY, botMidBoxArcX, botMidBoxArcY;
	private static 	int 		botRightBoxOffsetX, botRightBoxOffsetY, botRightBoxSizeX, botRightBoxSizeY, botRightBoxArcX, botRightBoxArcY;
	private static int 			farRightBoxOffsetX, farRightBoxOffsetY, farRightBoxSizeX, farRightBoxSizeY, farRightBoxArcX, farRightBoxArcY;
	private static int 			farfarRightBoxOffsetX, farfarRightBoxOffsetY, farfarRightBoxSizeX, farfarRightBoxSizeY, farfarRightBoxArcX, farfarRightBoxArcY;
							
	private 	  	Color 		transpColor;
	private 	   	Image 		fadeLine;
	
	private 		Cities 			cities;
	private 		AgentHandler	agentHandler;

	public static void main(String[] args) 
	{ 
		game = new Game();
		game.addWindowListener(new BadCloser());
		game.init();
		game.run(false, gameWindowX, gameWindowY); // need to generalise screen pixels for any given monitor
	}
	
	public void init()
	{		
		// Animation
		wMapAni 			= new Animation();
		tThemeAni 			= new Animation();
		bThemeAni 			= new Animation();
		cityGreenAni 		= new Animation();
		cityYellowAni 		= new Animation();
		cityRedAni 			= new Animation();
		
		// Map
		mapName 			= "res/wMap.jpg";
		themeName 			= "res/theme.jpg";
		
		wMapAni.addFrame(Toolkit.getDefaultToolkit().createImage(mapName), 10); // 10 is just a filler number
		tThemeAni.addFrame(Toolkit.getDefaultToolkit().createImage(themeName), 10);
		bThemeAni.addFrame(Toolkit.getDefaultToolkit().createImage(themeName), 10);
		
		// Sprite
		wMap 				= new Sprite(wMapAni);
		tTheme 				= new Sprite(tThemeAni);
		bTheme	 			= new Sprite(bThemeAni);
		
		// Game
		gameWindowX 		= 1365; 
		gameWindowY 		= 730;
		
		// Values
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
		timeOffsetY 		= 80;
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
		hpBoxSizeY 			= 30;
		hpBoxArcX 			= 20;
		hpBoxArcY  			= 20;
		hpMax 				= 150;
		hp 					= hpMax;
		
		botBoxColor 		= Color.BLACK;
		botLeftBoxOffsetX 	= 30;
		botLeftBoxOffsetY 	= 605;
		botLeftBoxSizeX 	= 415;
		botLeftBoxSizeY 	= 100;
		botLeftBoxArcX  	= 20;
		botLeftBoxArcY 		= 20;
		
		botMidBoxOffsetX 	= botLeftBoxOffsetX + botLeftBoxSizeX + 30;
		botMidBoxOffsetY 	= botLeftBoxOffsetY;
		botMidBoxSizeX 		= 250;
		botMidBoxSizeY 		= botLeftBoxSizeY;
		botMidBoxArcX	 	= 20;
		botMidBoxArcY  		= 20;

		botRightBoxOffsetX 	= botMidBoxOffsetX + botMidBoxSizeX + 30;
		botRightBoxOffsetY 	= botMidBoxOffsetY;
		botRightBoxSizeX 	= botMidBoxSizeX;
		botRightBoxSizeY 	= botMidBoxSizeY;
		botRightBoxArcX	 	= 20;
		botRightBoxArcY  	= 20;
		
		farRightBoxOffsetX 	= botRightBoxOffsetX + botRightBoxSizeX + 30;
		farRightBoxOffsetY	= botRightBoxOffsetY;
		farRightBoxSizeX 	= 200;
		farRightBoxSizeY 	= botRightBoxSizeY;
		farRightBoxArcX	 	= 20;
		farRightBoxArcY  	= 20;
		
		farfarRightBoxOffsetX 	= farRightBoxOffsetX + farRightBoxSizeX + 30;
		farfarRightBoxOffsetY	= farRightBoxOffsetY;
		farfarRightBoxSizeX 	= 60;
		farfarRightBoxSizeY 	= farRightBoxSizeY;
		farfarRightBoxArcX	 	= 20;
		farfarRightBoxArcY  	= 20;
		
		// Transparent Effect
		transpColor 		= new Color(0, 0, 0, 0.5f);
		fadeLine 			= Toolkit.getDefaultToolkit().createImage("res/line.png");

//		// Sound
//		Sound s = new Sound("res/music.wav");
//		s.start();
		
		// Cities
		cities 				= new Cities();
		agentHandler 		= new AgentHandler();
	}
	
	public void drawtTheme(Graphics2D g)
	{
		for (int i = 0; i < 50; i++)
		{
			g.drawImage(tThemeAni.getImage(), tThemeOffsetX, tThemeOffsetY, tThemeSizeX, tThemeSizeY, this);
			tThemeOffsetX = tThemeOffsetX + tThemeSizeX;			
		}
		tThemeOffsetX = tThemeOffsetXInit;
		tThemeSizeX = tThemeSizeXInit;
	}
	
	public void drawbTheme(Graphics2D g)
	{
		for (int i = 0; i < 50; i++)
		{
			g.drawImage(bThemeAni.getImage(), bThemeOffsetX, bThemeOffsetY, bThemeSizeX, bThemeSizeY, this);
			bThemeOffsetX = bThemeOffsetX + bThemeSizeX;			
		}
		bThemeOffsetX = bThemeOffsetXInit;
		bThemeSizeX = bThemeSizeXInit;
	}
	
	public void drawMoney(Graphics2D g)
	{
		g.setColor(transpColor);
		g.fillRoundRect(moneyBoxOffsetX, moneyBoxOffsetY, moneyBoxSizeX, moneyBoxSizeY, moneyBoxArcX, moneyBoxArcY);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("Money", moneyOffsetX, moneyOffsetY);
		g.setColor(moneyColor);
		g.drawRoundRect(moneyBoxOffsetX, moneyBoxOffsetY, moneyBoxSizeX, moneyBoxSizeY, moneyBoxArcX, moneyBoxArcY);
		g.drawRoundRect(moneyBoxOffsetX + 1, moneyBoxOffsetY + 1, moneyBoxSizeX - 2, moneyBoxSizeY - 2, moneyBoxArcX, moneyBoxArcY);
		g.drawRoundRect(moneyBoxOffsetX + 2, moneyBoxOffsetY + 2, moneyBoxSizeX - 4, moneyBoxSizeY - 4, moneyBoxArcX, moneyBoxArcY);
	}
	
	public void drawTime(Graphics2D g)
	{
		g.setColor(transpColor);
		g.fillRoundRect(timeBoxOffsetX, timeBoxOffsetY, timeBoxSizeX, timeBoxSizeY, timeBoxArcX, timeBoxArcY);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("Time", timeOffsetX, timeOffsetY);
		g.setColor(timeColor);
		g.drawRoundRect(timeBoxOffsetX, timeBoxOffsetY, timeBoxSizeX, timeBoxSizeY, timeBoxArcX, timeBoxArcY);
		g.drawRoundRect(timeBoxOffsetX + 1, timeBoxOffsetY + 1, timeBoxSizeX - 2, timeBoxSizeY - 2, timeBoxArcX, timeBoxArcY);
		g.drawRoundRect(timeBoxOffsetX + 2, timeBoxOffsetY + 2, timeBoxSizeX - 4, timeBoxSizeY - 4, timeBoxArcX, timeBoxArcY);
	}
	
	public void drawHP(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRoundRect(hpBoxOffsetX, hpBoxOffsetY, hpMax, hpBoxSizeY, hpBoxArcX, hpBoxArcY);
		g.setColor(hpBoxColor);
		g.drawRoundRect(hpBoxOffsetX, hpBoxOffsetY, hpMax, hpBoxSizeY, hpBoxArcX, hpBoxArcY);
		g.drawRoundRect(hpBoxOffsetX + 1, hpBoxOffsetY + 1, hpMax - 2, hpBoxSizeY - 2, hpBoxArcX, hpBoxArcY);
		g.drawRoundRect(hpBoxOffsetX + 2, hpBoxOffsetY + 2, hpMax - 4, hpBoxSizeY - 4, hpBoxArcX, hpBoxArcY);
		g.setColor(hpColor);
		g.fillRoundRect(hpBoxOffsetX + 3, hpBoxOffsetY + 3, hp - 6, hpBoxSizeY - 5, hpBoxArcX, hpBoxArcY);
	}
	
	public void drawBotLeft(Graphics2D g)
	{
		g.setColor(transpColor);
		g.fillRoundRect(botLeftBoxOffsetX, botLeftBoxOffsetY, botLeftBoxSizeX, botLeftBoxSizeY, botLeftBoxArcX, botLeftBoxArcY);
		g.setColor(botBoxColor);
		g.drawRoundRect(botLeftBoxOffsetX, botLeftBoxOffsetY, botLeftBoxSizeX, botLeftBoxSizeY, botLeftBoxArcX, botLeftBoxArcY);
		g.drawRoundRect(botLeftBoxOffsetX + 1, botLeftBoxOffsetY + 1, botLeftBoxSizeX - 2, botLeftBoxSizeY - 2, botLeftBoxArcX, botLeftBoxArcY);
		g.drawRoundRect(botLeftBoxOffsetX + 2, botLeftBoxOffsetY + 2, botLeftBoxSizeX - 4, botLeftBoxSizeY - 4, botLeftBoxArcX, botLeftBoxArcY);
	
		drawBotLeftDetails(g);
	}

	public void drawBotMid(Graphics2D g)
	{
		g.setColor(transpColor);
		g.fillRoundRect(botMidBoxOffsetX, botMidBoxOffsetY, botMidBoxSizeX, botMidBoxSizeY, botMidBoxArcX, botMidBoxArcY);
		g.setColor(botBoxColor);
		g.drawRoundRect(botMidBoxOffsetX, botMidBoxOffsetY, botMidBoxSizeX, botMidBoxSizeY, botMidBoxArcX, botMidBoxArcY);
		g.drawRoundRect(botMidBoxOffsetX + 1, botMidBoxOffsetY + 1, botMidBoxSizeX - 2, botMidBoxSizeY - 2, botMidBoxArcX, botMidBoxArcY);
		g.drawRoundRect(botMidBoxOffsetX + 2, botMidBoxOffsetY + 2, botMidBoxSizeX - 4, botMidBoxSizeY - 4, botMidBoxArcX, botMidBoxArcY);
	
		drawBotMidDetails(g);
	}
	
	public void drawBotRight(Graphics2D g)
	{
		g.setColor(transpColor);
		g.fillRoundRect(botRightBoxOffsetX, botRightBoxOffsetY, botRightBoxSizeX, botRightBoxSizeY, botRightBoxArcX, botRightBoxArcY);
		g.setColor(botBoxColor);
		g.drawRoundRect(botRightBoxOffsetX, botRightBoxOffsetY, botRightBoxSizeX, botRightBoxSizeY, botRightBoxArcX, botRightBoxArcY);
		g.drawRoundRect(botRightBoxOffsetX + 1, botRightBoxOffsetY + 1, botRightBoxSizeX - 2, botRightBoxSizeY - 2, botRightBoxArcX, botRightBoxArcY);
		g.drawRoundRect(botRightBoxOffsetX + 2, botRightBoxOffsetY + 2, botRightBoxSizeX - 4, botRightBoxSizeY - 4, botRightBoxArcX, botRightBoxArcY);
	
		drawBotRightDetails(g);
	}
	
	public void drawFarRight(Graphics2D g)
	{
		g.setColor(transpColor);
		g.fillRoundRect(farRightBoxOffsetX, farRightBoxOffsetY, farRightBoxSizeX, farRightBoxSizeY, farRightBoxArcX, farRightBoxArcY);
		g.setColor(botBoxColor);
		g.drawRoundRect(farRightBoxOffsetX, farRightBoxOffsetY, farRightBoxSizeX, farRightBoxSizeY, farRightBoxArcX, farRightBoxArcY);
		g.drawRoundRect(farRightBoxOffsetX + 1, farRightBoxOffsetY + 1, farRightBoxSizeX - 2, farRightBoxSizeY - 2, farRightBoxArcX, farRightBoxArcY);
		g.drawRoundRect(farRightBoxOffsetX + 2, farRightBoxOffsetY + 2, farRightBoxSizeX - 4, farRightBoxSizeY - 4, farRightBoxArcX, farRightBoxArcY);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		// Horizontal Lines
		for (int i = 1; i <= 2; i++)
		{
			g.drawLine(farRightBoxOffsetX + 3, (farRightBoxOffsetY + 3) + i*(farRightBoxSizeY - 4)/3, farRightBoxOffsetX + farRightBoxSizeX - 3, (farRightBoxOffsetY + 3) + i*(farRightBoxSizeY - 4)/3);
		}
	}
	
	public void drawFarFarRight(Graphics2D g)
	{
		g.setColor(transpColor);
		g.fillRoundRect(farfarRightBoxOffsetX, farfarRightBoxOffsetY, farfarRightBoxSizeX, farfarRightBoxSizeY, farfarRightBoxArcX, farfarRightBoxArcY);
		g.setColor(botBoxColor);
		g.drawRoundRect(farfarRightBoxOffsetX, farfarRightBoxOffsetY, farfarRightBoxSizeX, farfarRightBoxSizeY, farfarRightBoxArcX, farfarRightBoxArcY);
		g.drawRoundRect(farfarRightBoxOffsetX + 1, farfarRightBoxOffsetY + 1, farfarRightBoxSizeX - 2, farfarRightBoxSizeY - 2, farfarRightBoxArcX, farfarRightBoxArcY);
		g.drawRoundRect(farfarRightBoxOffsetX + 2, farfarRightBoxOffsetY + 2, farfarRightBoxSizeX - 4, farfarRightBoxSizeY - 4, farfarRightBoxArcX, farfarRightBoxArcY);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		// Horizontal Lines
		for (int i = 1; i <= 2; i++)
		{
			g.drawLine(farfarRightBoxOffsetX + 3, (farfarRightBoxOffsetY + 3) + i*(farfarRightBoxSizeY - 4)/3, farfarRightBoxOffsetX + farfarRightBoxSizeX - 3, (farfarRightBoxOffsetY + 3) + i*(farfarRightBoxSizeY - 4)/3);
		}
	}
	
	public void drawTransparency(Graphics2D g)
	{
		g.drawImage(fadeLine, 0, mapOffsetY - 1, 1400, 20, this);
		g.drawImage(fadeLine, 0, mapOffsetY - 1, 1400, -3, this);
		g.drawImage(fadeLine, 0, mapOffsetY + mapSizeY + 1, 1400, -20, this);
		g.drawImage(fadeLine, 0, mapOffsetY + mapSizeY + 1, 1400, 3, this);
	}
	
	private void drawCityIcons(Graphics2D g) 
	{
		int cityCount = cities.getNumberOfCities();
		for (int i = 0; i < cityCount; i++) 
		{
			City c = cities.getCityByIndex(i);
			g.drawImage(c.getImage(), (int)c.getX(), (int)c.getY(), c.getWidth(), c.getHeight(), this); 	
		}
		
	}
	
	private void drawMacOutline(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1400, 30);
		g.fillRect(0, 722, 1400, 30);
		g.fillRect(0, 0, 8, 1000);
		g.fillRect(1357, 0, 8, 1000);
	}
	
	private void drawBotLeftDetails(Graphics2D g)
	{
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("City Name: ", botLeftBoxOffsetX + 30, botLeftBoxOffsetY + 30);
		g.drawString("Human Population: ", botLeftBoxOffsetX + 30, botLeftBoxOffsetY + 55);
		g.drawString("Infected Population: ", botLeftBoxOffsetX + 30, botLeftBoxOffsetY + 80);
		
		int zombieBoxOffSetX = 260, zombieBoxOffSetY = 667;
		g.setColor(hpBoxColor);
		g.drawRoundRect(zombieBoxOffSetX, zombieBoxOffSetY, hpMax, hpBoxSizeY, hpBoxArcX, hpBoxArcY);
		g.drawRoundRect(zombieBoxOffSetX + 1, zombieBoxOffSetY + 1, hpMax - 2, hpBoxSizeY - 2, hpBoxArcX, hpBoxArcY);
		g.drawRoundRect(zombieBoxOffSetX + 2, zombieBoxOffSetY + 2, hpMax - 4, hpBoxSizeY - 4, hpBoxArcX, hpBoxArcY);
		g.setColor(Color.RED);
		g.fillRoundRect(zombieBoxOffSetX + 3, zombieBoxOffSetY + 3, hp - 4, hpBoxSizeY - 5, hpBoxArcX, hpBoxArcY);
		g.setColor(Color.WHITE);
		g.drawString("100%", botLeftBoxOffsetX + 288, botLeftBoxOffsetY + 83);
	}
	
	private void drawBotMidDetails(Graphics2D g)
	{
		g.setColor(Color.WHITE);
		// Horizontal Lines
		for (int i = 1; i <= 2; i++)
		{
			g.drawLine(botMidBoxOffsetX + 3, (botMidBoxOffsetY + 3) + i*(botMidBoxSizeY - 4)/3, botMidBoxOffsetX + botMidBoxSizeX - 3, (botMidBoxOffsetY + 3) + i*(botMidBoxSizeY - 4)/3);
		}
		
		// Vertical Lines
		for (int i = 1; i <= 4; i++)
		{
			g.drawLine((botMidBoxOffsetX + 3) + i*(botMidBoxSizeX - 4)/5, botMidBoxOffsetY + 3, (botMidBoxOffsetX + 3) + i*(botMidBoxSizeX - 4)/5, (botMidBoxOffsetY + 3) + (botMidBoxSizeY - 6));
		}
	}
	
	private void drawBotRightDetails(Graphics2D g)
	{
		g.setColor(Color.WHITE);
		// Horizontal Lines
		for (int i = 1; i <= 2; i++)
		{
			g.drawLine(botRightBoxOffsetX + 3, (botRightBoxOffsetY + 3) + i*(botRightBoxSizeY - 4)/3, botRightBoxOffsetX + botRightBoxSizeX - 3, (botRightBoxOffsetY + 3) + i*(botRightBoxSizeY - 4)/3);
		}
		
		// Vertical Lines
		for (int i = 1; i <= 4; i++)
		{
			g.drawLine((botRightBoxOffsetX + 3) + i*(botRightBoxSizeX - 4)/5, botRightBoxOffsetY + 3, (botRightBoxOffsetX + 3) + i*(botRightBoxSizeX - 4)/5, (botRightBoxOffsetY + 3) + (botRightBoxSizeY - 6));
		}
		
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
		drawtTheme(g);
		
		// Time
		drawTime(g);
				
		// Money
		drawMoney(g);
		
		// HP
		drawHP(g);

		// Bot Theme
		drawbTheme(g);

		// BotLeft Box
		drawBotLeft(g);
		
		// BotMid Box
		drawBotMid(g);
		
		// BotRight Box
		drawBotRight(g);
		
		// Bot FarRight Box
		drawFarRight(g);
		
		// Bot FarFarRight Box
		drawFarFarRight(g);
		
		// Apply transparency
		drawTransparency(g);
		
		// Cities
		drawCityIcons(g);		
		
		// macbook outline
		drawMacOutline(g);	
	
	}	
}
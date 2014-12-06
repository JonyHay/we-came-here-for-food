package hack;

import java.awt.Graphics2D;
import game2D.GameCore;

@SuppressWarnings("serial")
public class Game extends GameCore {
	
	public static void main(String[] args) { 
		
		Game game = new Game();
		game.run(false, 640, 480);
		
	}

	@Override
	public void draw(Graphics2D g) {
		
	}

}

package tantibus.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {
	

	public Player(float x, float y) throws SlickException{
		super (x,y);
		Image img = new Image("images/character_prototype_01.jpg");
		
		maxSpeed = 0.2f;
		maxFallSpeed = 0.4f;
	}
}
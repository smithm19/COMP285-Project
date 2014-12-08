package tantibus.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {
	

	public Player(float x, float y) throws SlickException{
		super (x,y);
		setSprite(new Image("images/characters/p1_walk01.png"));
		setMovingAnimation(new Image[]{new Image("images/characters/p1_walk01.png"), new Image ("images/characters/p1_walk02.png"), new Image("images/characters/p1_walk03.png"),new Image("p1_walk04.png"),new Image("images/characters/p1_walk05.png"),new Image("images/characters/p1_walk06.png"),new Image("images/characters/p1_walk07.png"),new Image("images/characters/p1_walk08.png"),new Image("images/characters/p1_walk09.png"),new Image("images/characters/p1_walk10.png"),new Image("images/characters/p1_walk11.png")}, 125);
		
		//TODO   boundingShape = new AABoundingRect(x+3, y, 26, 32);
		
		accelerationSpeed = 0.002f;
		decelerationSpeed = 0.002f;
		maxSpeed = 0.2f;
		maxFallSpeed = 0.4f;
	}

	/*TODO public void updateBoundingShape(){
				boundingShape.updatePosition(x+4,y);
			}
	*/
}
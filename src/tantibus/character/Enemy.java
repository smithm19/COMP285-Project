package tantibus.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import tantibus.physics.AACollisionDetection;

public class Enemy extends Character{
	AACollisionDetection collisionDetection;
	public Enemy (float x, float y) throws SlickException{
		super (x,y);
		setSprite(new Image("images/characters/slimeWalk1.png"));
		setMovingAnimation(new Image[]{new Image("images/characters/slimeWalk1.png"),
									new Image ("images/characters/slimeWalk2.png")}, 50);
	
		

		
		collisionDetection = new AACollisionDetection(x + 3, y, 26, 32);
		
		accelerationSpeed = 0.2f;
		decelerationSpeed = 0.2f;
		maxSpeed = 0.2f;
		maxFallSpeed = 0.4f;
	}

	public void updateCollisionDetection() {
		collisionDetection.updatePosition(x + 4, y);
	}
}

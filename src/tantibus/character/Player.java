package tantibus.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import tantibus.enums.Facing;
import tantibus.physics.AACollisionDetection;

public class Player extends Character {
	
	public Player(float x, float y) throws SlickException{
		super (x,y);
		setSprite(new Image("images/characters/p1_walk02.png"));
		setMovingAnimation(new Image[]{new Image("images/characters/p1_walk01.png"),
									new Image ("images/characters/p1_walk02.png"), new Image("images/characters/p1_walk03.png"),
									new Image("images/characters/p1_walk04.png"),new Image("images/characters/p1_walk05.png"),
									new Image("images/characters/p1_walk06.png"),new Image("images/characters/p1_walk07.png"),
									new Image("images/characters/p1_walk08.png"),new Image("images/characters/p1_walk09.png"),
									new Image("images/characters/p1_walk10.png"),new Image("images/characters/p1_walk11.png")}, 50);
		
		collisionDetection = new AACollisionDetection(x + 3, y, 26, 32);

		accelerationSpeed = 0.001f;
		decelerationSpeed = 0.001f;
		maxSpeed = 0.15f;
		maxFallSpeed = 0.3f;
	}

	public void updateCollisionDetection() {
		collisionDetection.updatePosition(x + 3, y);
	}
}
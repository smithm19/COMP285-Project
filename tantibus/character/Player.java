package tantibus.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import tantibus.physics.AACollisionDetection;

public class Player extends Character {
	AACollisionDetection collisionDetection;
	public Player(float x, float y) throws SlickException{
		super (x,y);
		setSprite(new Image("images/characters/p1_stand.png"));
		setMovingAnimation(new Image[]{new Image("images/characters/p1_walk01.png"),
									new Image ("images/characters/p1_walk02.png"), new Image("images/characters/p1_walk03.png"),
									new Image("images/characters/p1_walk04.png"),new Image("images/characters/p1_walk05.png"),
									new Image("images/characters/p1_walk06.png"),new Image("images/characters/p1_walk07.png"),
									new Image("images/characters/p1_walk08.png"),new Image("images/characters/p1_walk09.png"),
									new Image("images/characters/p1_walk10.png"),new Image("images/characters/p1_walk11.png")}, 50);
		
		setJumpingAnimation(new Image[]{new Image("images/characters/p1_jump.png"), new Image("images/characters/p1_hurt.png"), new Image("images/characters/p1_duck.png"), new Image("images/characters/p1_stand.png") }, 200);
		
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
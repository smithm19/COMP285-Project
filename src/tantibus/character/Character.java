package tantibus.character;

import java.util.HashMap;

// game files import
import tantibus.enums.Facing;
import tantibus.level.LevelObject;

// slick2D library import
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

public abstract class Character extends LevelObject {
	
	protected float maxSpeed = 1;
	protected float accelerationSpeed = 1;
	protected float decelerationSpeed = 1;
	protected Facing facing;
	protected boolean movement = false;
	
	protected HashMap<Facing, Image> sprites;
	protected HashMap<Facing,Animation> movingAnimations;
	
	protected boolean jump = false;

	public Character(float x, float y) throws SlickException {
		super(x, y);
		facing = Facing.RIGHT; //default direction
		setSprite(new Image("images/characters/p1_walk02.png"));
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setSprite(Image img){
		sprites = new HashMap<Facing,Image>();
		sprites.put(Facing.RIGHT, img);
		sprites.put(Facing.LEFT , img.getFlippedCopy(true, false));
	}
	
	protected void setMovingAnimation(Image[] images, int frameDuration){
		movingAnimations = new HashMap<Facing,Animation>();

		//we can just put the right facing in with the default images
		movingAnimations.put(Facing.RIGHT, new Animation(images,frameDuration));

		Animation facingLeftAnimation = new Animation();
		for(Image i : images){
			facingLeftAnimation.addFrame(i.getFlippedCopy(true, false), frameDuration);
		}
		movingAnimations.put(Facing.LEFT, facingLeftAnimation);

	}
	
	public boolean isMoving(){
		return movement;
	}

	public void setMovement(boolean move){
		movement = move;
	}

	//move towards x_velocity = 0
	public void decelerate(int delta) {
		if(x_velocity > 0){
			x_velocity -= decelerationSpeed * delta;
			if(x_velocity < 0)
				x_velocity = 0;
		}else if(x_velocity < 0){
			x_velocity += decelerationSpeed * delta;
			if(x_velocity > 0)
				x_velocity = 0;
		}
	}
	
	public void jump(){
		if(onGround){
			y_velocity = -0.4f;
		}
	}

	public void moveLeft(int delta){
		//if we aren't already moving at maximum speed
		if(x_velocity > -maxSpeed) {
			//accelerate
			x_velocity -= accelerationSpeed*delta;
			if(x_velocity < -maxSpeed) {
				//and if we exceed maximum speed, set it to maximum speed
				x_velocity = -maxSpeed;
			}
		}
		movement = true;
		facing = Facing.LEFT;
	}

	public void moveRight(int delta){
		if(x_velocity < maxSpeed){
			x_velocity += accelerationSpeed*delta;
			if(x_velocity > maxSpeed){
				x_velocity = maxSpeed;
			}
		}
		movement = true;
		facing = Facing.RIGHT;
	}
	
	public void render() {
		//draw a moving animation if we have one and we moved within the last 150 miliseconds
		if(movingAnimations != null && movement){
			movingAnimations.get(facing).draw(x-2,y-2);
		}else{
			sprites.get(facing).draw(x-2, y-2);
		}
	}
}


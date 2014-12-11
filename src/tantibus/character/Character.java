package tantibus.character;

import java.util.HashMap;

// game files import
import tantibus.enums.Facing;
import tantibus.level.LevelObject;

// slick2D library import
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

public abstract class Character {
	
	protected float x;
	protected float y;
	protected Facing facing;
	protected HashMap<Facing, Image> sprites;
	protected HashMap<Facing,Animation> movingAnimations;
	protected long lastTimeMoved;
	/*
	
	protected HashMap<Facing, Animation> movementAnimation;
	protected HashMap<Facing, Animation> jumpingAnimation;
	protected boolean movement = false;
	protected boolean jump = false;
	protected boolean jumpingMovement = false;
	protected float maxSpeed = 1;
	protected float accelerationSpeed = 2;
	protected float decelerationSpeed = 2;
	*/

	public Character(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		facing = Facing.RIGHT; //default direction
		Image sprite = new Image("images/characters/p1_walk02.png");
		setSprite(sprite);
		/*
		super(x,y);
		
		this.x = positionX;
		this.y = positionY;
		
		
		*/
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void render() {
		//draw a moving animation if we have one and we moved within the last 150 miliseconds
		if(movingAnimations != null && lastTimeMoved+150 > System.currentTimeMillis()){
			movingAnimations.get(facing).draw(x-2,y-2);
		}else{
			sprites.get(facing).draw(x-2, y-2);
		}
	}
	
	public void setSprite(Image img){
		sprites = new HashMap<Facing, Image>();
		sprites.put(Facing.LEFT, img.getFlippedCopy(true, false));
		sprites.put(Facing.RIGHT, img);
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
	/*
	protected void setMovingAnimation(Image[] images, int frameDuration){
		movementAnimation = new HashMap<Facing, Animation>();
		movementAnimation.put(Facing.right, new Animation(images, frameDuration));
		Animation facingLeftAnimation = new Animation();
		for(Image i: images){
			facingLeftAnimation.addFrame(i.getFlippedCopy(true, false), frameDuration);
		}
		movementAnimation.put(Facing.left, facingLeftAnimation);
	}
	
	protected void setJumpingAnimation(Image[] images, int frameDuration){
		jumpingAnimation = new HashMap<Facing, Animation>();
		jumpingAnimation.put(Facing.right, new Animation(images, frameDuration));
		Animation facingLeftAnimation = new Animation();
		for(Image i: images){
			facingLeftAnimation.addFrame(i.getFlippedCopy(true, false), frameDuration);
		}
		jumpingAnimation.put(Facing.left, facingLeftAnimation);
	}
	public boolean isMoving(){
		return movement;
	}
	
	public boolean isJumping(){
		return jumpingMovement;
	}

	public void setMovement(boolean move){
		movement = move;
	}

	public void jump(){
		if(onGround){
			ySpeed = -0.4f;
		}
	}

	public void movementLeft(int delta){

		
		positionX = positionX - (0.15f*delta);
	
		movement = true;
		facing = Facing.left;
	}

	public void movementRight(int delta){

			
		positionX = positionX + (0.15f*delta);
		
		movement = true;
		facing = Facing.right;
	}
	

	public void render(float offsetX, float offsetY){

		if(movement){
			
			movementAnimation.get(facing).draw(positionX-1-offsetX,positionY-1-offsetY);	
		}
		else if(jumpingMovement){
			
				jumpingAnimation.get(facing).draw(positionX-20+offsetX,positionY-20+offsetY);		
		}
		else{
			sprites.get(facing).draw(positionX-1-offsetX,positionY-1-offsetY);	
		}

	}
	*/
}


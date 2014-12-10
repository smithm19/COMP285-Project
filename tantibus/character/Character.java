package tantibus.character;

import java.util.HashMap;

import tantibus.enums.Facing;
import tantibus.level.LevelObject;
import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;



public abstract class Character extends LevelObject {
	    
	protected HashMap<Facing, Image> sprites;
	protected HashMap<Facing, Animation> movementAnimation;
	protected HashMap<Facing, Animation> jumpingAnimation;
	protected boolean movement = false;
	protected boolean jump = false;
	protected boolean jumpingMovement = false;
	protected float maxSpeed = 1;
	protected float accelerationSpeed = 2;
	protected float decelerationSpeed = 2;
	protected Facing facing;

	public Character(float x, float y) throws SlickException{
		super(x,y);
		setSprite(new Image("images/Place_holder.png"));
		facing = Facing.left;
	}


	public void setSprite(Image img){
		sprites = new HashMap<Facing, Image>();
		sprites.put(Facing.right, img.getFlippedCopy(true, false));
		sprites.put(Facing.left, img);
	}

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

	
	public void decelerate(int delta){
		if(xSpeed > 0){
			xSpeed -= decelerationSpeed*delta;
			if(xSpeed < 0){
				xSpeed = 0;
			}
		}
		else if(xSpeed < 0){
			if(xSpeed > 0){
				xSpeed = 0;
			}
		}

	}
	public void jump(int delta){
		if(onGround){
			ySpeed = -0.4f;	
			jumpingMovement = true;
		}
		else
			jumpingMovement = false;
			
	}

	public void movementLeft(int delta){

//		if(xSpeed >- maxSpeed){
//			xSpeed -= accelerationSpeed*delta;
//			if(xSpeed < -maxSpeed){
//				xSpeed = -maxSpeed;
//			}
//
//		}
		
		xSpeed -= (0.15f*delta);
		movement = true;
		facing = Facing.left;
	}

	public void movementRight(int delta){

//		if(xSpeed < maxSpeed){
//			xSpeed += accelerationSpeed*delta;
//			if(xSpeed > -maxSpeed){
//				xSpeed = maxSpeed;
//			}
//
//		}
		xSpeed += (0.15f*delta);
		movement = true;
		facing = Facing.right;
	}
	

	public void render(float offsetX, float offsetY){

		if(movement){
			movementAnimation.get(facing).draw(x-1-offsetX,y-1-offsetY);	
		}
		else if(jumpingMovement){
			
				jumpingAnimation.get(facing).draw(x-20+offsetX,y-20+offsetY);	
				
			
			
		}
		else{
			sprites.get(facing).draw(x-1-offsetX,y-1-offsetY);	
		}

	}

}


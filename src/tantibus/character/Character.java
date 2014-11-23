package tantibus.character;

import java.util.HashMap;

import tantibus.enums.Facing;
import tantibus.level.LevelObject;
import tantibus.enums.Gravity;

import org.newdawn.slick.Image;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;



public abstract class Character extends LevelObject {
	
	

    
	protected HashMap<Facing, Image> sprites;
    protected HashMap<Facing,HashMap<Gravity,Animation>> movementAnimation;
	protected boolean movement = false;
	protected boolean jump = false;
	protected float maxSpeed = 1;
	protected Facing facing;
	
	public Character(float x, float y) throws SlickException{
		super(x,y);
		Image img = new Image("images/Place_holder.png");
		facing = Facing.right;
	}
	
	
	public void setSprite(Image img){
		sprites = new HashMap<Facing, Image>();
		sprites.put(Facing.left, img);
		sprites.put(Facing.right, img);
	}
	public boolean isMoving(){
		return movement;
	}
	
	public void setMovement(boolean move){
		movement = move;
	}
	
	public void jump(Gravity gravity){
		if(onGround){
			switch(gravity){
				case down:
					ySpeed = -0.5f;
					break;
				case up:
					ySpeed = 0.5f;
					break;
				case right:
					xSpeed = 0.5f;
					break;
				case left:
					xSpeed = -0.5f;
					break;
			}
		}
	}
	
	public void movementLeft(int delta){
		
				if(xSpeed >- maxSpeed){
					xSpeed -= maxSpeed*delta;
					if(xSpeed < -maxSpeed){
						xSpeed = -maxSpeed;
					}
				
		
				
				
			
		}
		movement = true;
		facing = Facing.left;
	}
	
	public void movementRight(int delta){
		
				if(xSpeed < maxSpeed){
					xSpeed += maxSpeed*delta;
					if(xSpeed > -maxSpeed){
						xSpeed = maxSpeed;
				}
			
			}
		movement = true;
		facing = Facing.right;
	}

	public void render(float offset_x, float offset_y, Gravity gravity){
		
	
		if(movementAnimation != null & movement){
			movementAnimation.get(facing).get(gravity).draw(x-2-offset_x,y-2-offset_y);	
		}
		else{
			sprites.get(facing).draw(x-2-offset_x,y-2-offset_y);	
		}
		
	}

}


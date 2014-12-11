package tantibus.level;

import tantibus.physics.AACollisionDetection;
import tantibus.physics.CollisionDetection;



public abstract class LevelObject {
	
	protected float x;
	protected float	y;
	protected float	xSpeed = 0;
	protected float	ySpeed = 0;
	protected float maxFallSpeed = 1;
	protected boolean onGround = true;
	protected float positionX;
	protected float positionY;
	protected CollisionDetection collisionDetection;

	public LevelObject(float x, float y){
		this.x = x;
		this.y = y;
		
		collisionDetection = new AACollisionDetection(x,y, 32, 32); //collision detection on a square 32x32 (tile size)
	}
	
	public void applyGravity(float gravity){
		
			if(ySpeed< maxFallSpeed){
				ySpeed += gravity;
				if(ySpeed > maxFallSpeed){
					ySpeed = maxFallSpeed;
				}
			}
	}
		
	public float getYPosition(){
		return positionY;
	}
	
	public float getXPosition(){
		return positionX;
	}
	
	public float getYSpeed(){
			return ySpeed;
		}
	
	public float getXSpeed(){
		return xSpeed;
	}
	
	public void setYSpeed(float f){
		ySpeed = f;
	}
	
	public void setXSpeed(float f){
		xSpeed = f;
	}
	
	public float getY(){
		return y;
	}
	
	public float getX(){
		return x;
	}
	
	public void setY(float f){
		y = f;
		updateCollisionDetection();
		
	}
	
	public void setX(float f){
		x = f;
		updateCollisionDetection();
	}
	
	public void updateCollisionDetection(){
		collisionDetection.updatePosition(x,y);
	}
	
	public boolean isOnGround(){
		return onGround;
	}
	
	public void setOnGround(boolean oG){
		onGround = oG;
	}
	
	public CollisionDetection getCollisionDetection(){
		return collisionDetection;
	}
	
	public abstract void render(float offset_x, float offset_y);

}


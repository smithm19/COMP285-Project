package tantibus.level;

import tantibus.physics.AACollisionDetection;
import tantibus.physics.CollisionDetection;



public abstract class LevelObject {
	
	protected float x;
	protected float	y;
	protected CollisionDetection collisionDetection;
	
	protected float	x_velocity = 0;
	protected float	y_velocity = 0;
	protected float maxFallSpeed = 1;
	
	protected boolean onGround = true;


	public LevelObject(float x, float y){
		this.x = x;
		this.y = y;
		
		//collision detection on a square 32x32 (tile size)
		collisionDetection = new AACollisionDetection(x,y, 32, 32); 
	}
	
	public void applyGravity(float gravity){
			if(y_velocity< maxFallSpeed) {
				y_velocity += gravity;
				if(y_velocity > maxFallSpeed) {
					y_velocity = maxFallSpeed;
				}
			}
	}
		
	public float getYVelocity() {
		return y_velocity;
	}
	
	public float getXVelocity() {
		return x_velocity;
	}
	
	public void setYVelocity(float f){
		y_velocity = f;
	}
	
	public void setXVelocity(float f){
		x_velocity = f;
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

}


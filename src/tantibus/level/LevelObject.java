package tantibus.level;

import tantibus.enums.Gravity;



public abstract class LevelObject {
	
	protected float x;
	protected float	y;
	protected float	xSpeed = 0;
	protected float	ySpeed = 0;
	protected float maxFallSpeed = 1;
				
	
	
	public LevelObject(float x, float y){
		this.x = x;
		this.y = y;
		
		//collision detection goes here
	}
	
	public void Gravity(float force, Gravity gravity){
		switch(gravity){
		case up:
			if(ySpeed > -maxFallSpeed){
				//accelarates
				ySpeed -= force;
				if(ySpeed < -maxFallSpeed){
					ySpeed = maxFallSpeed;
				}
			}
			break;
		
		case down:
			if(ySpeed < maxFallSpeed){
				ySpeed += force;
				if(ySpeed > maxFallSpeed){
					ySpeed = maxFallSpeed;
				}
			}
			break;
		case right:
			if(xSpeed < maxFallSpeed){
				xSpeed += force;
				if(xSpeed > maxFallSpeed){
					xSpeed = maxFallSpeed;
				}
			}
			break;
		case left:
			if (xSpeed > -maxFallSpeed){
				xSpeed -= force;
				if(xSpeed < -maxFallSpeed){
					xSpeed = -maxFallSpeed;
				}
			}
			break;
		}
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
		
	}
	
	public void setX(float f){
		x = f;
	}
	
	public abstract void render(float offset_x, float offset_y, Gravity gravity);

}


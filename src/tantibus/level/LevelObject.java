package tantibus.level;

import tantibus.enums.Gravity;



public abstract class LevelObject {
	
	protected float x;
	protected float	y;
	protected float	xSpeed = 0;
	protected float	ySpeed = 0;
	protected float maxFallSpeed = 1;
	protected boolean onGround = true;
	//protected BoundingShape boundingShape;

	public LevelObject(float x, float y){
		this.x = x;
		this.y = y;
		
		//boundingShape = new AABoundingRect(x,y, 32, 32);
	}
	
	public void applyGravity(float gravity){
		
			if(ySpeed< maxFallSpeed){
				ySpeed += gravity;
				if(ySpeed > maxFallSpeed){
					ySpeed = maxFallSpeed;
				}
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
		//updateBoundingShape();
		
	}
	
	public void setX(float f){
		x = f;
		//updateBoundingShape();
	}
	
	/*public void updateBoundingShape(){
    	boundingShape.updatePosition(x,y);
	}*/
	
	public boolean isOnGround(){
		return onGround;
	}
	
	public void setOnGround(boolean oG){
		onGround = oG;
	}
	
	/*public BoundingShape getBoundingShape(){
		return boundingShape;
	}*/
	
	public abstract void render(float offset_x, float offset_y);

}


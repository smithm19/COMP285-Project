package tantibus.level;

import tantibus.enums.Gravity;



public class LevelObject {
	
	protected float x,
					y,
					xSpeed = 0,
					ySpeed = 0,
					
	
	
	public LevelObject(float x, float y){
		this.x = x;
		this.y = y;
		
		//collision detection goes here
	}
	
	public void Gravity(float force, Gravity gravity){
		switch(gravity){
		case up:
			if(ySpeed > )
		}
	}
	

}

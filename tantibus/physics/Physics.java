package tantibus.physics;

import java.util.ArrayList;

import tantibus.level.Level;
import tantibus.level.LevelObject;
import tantibus.level.Tile;
import tantibus.character.Character;
import tantibus.physics.CollisionDetection;
public class Physics {

	
	private final float gravity = 0.4f;
	
	public void controlPhysics(Level level, int delta){
		controlLevelObjects(level, delta);
	}

	
	private void controlLevelObjects(Level level, int delta){
		for(LevelObject o: level.getLevelObjects()){
			controlGameObject(o, level, delta);
		}
	}
	
	private void controlGameObject(LevelObject obj, Level level, int delta){
		
		obj.setOnGround(isOnGround(obj, level.getTiles())); //updates object
		
		if(!obj.isOnGround() || obj.getYSpeed() < 0){ //applies gravity if in air, or jumping
			obj.applyGravity(gravity*delta);
		}
		else{
			obj.setYSpeed(0);
		}
		
		float xMovement = obj.getXSpeed()*delta;// calculates movement
		float yMovement = obj.getYSpeed()*delta;
		
		float stepX = 0; //calculates steps
		float stepY = 0;
		
		if(xMovement != 0){
			stepY = Math.abs(yMovement)/Math.abs(xMovement);
			if(yMovement < 0){
				stepY = -stepY;
			}
			
			if(xMovement > 0){
				stepX = 1;
			}
			else{
				stepX = -1;
			}
			
			if((stepY > 1 || stepY < -1) && stepY != 0){
				stepX = Math.abs(stepX)/Math.abs(stepY);
				if(xMovement < 0){
					stepX = -stepX;
				}
				if(yMovement < 0){
					stepY = -1;
				}
				else{
					stepY = 1;
				}
			}
		}
	}
	
	private boolean isOnGround(LevelObject obj, Tile[][] mapTile){
		
		ArrayList<Tile> tiles = obj.getCollisionDetection().getTiles(mapTile);//get ground tiles
		
		obj.getCollisionDetection().movePosition(0, 1); //moves tile down to check if character is above the ground
		
		for(Tile t: tiles){
			if(t.getCollisionDetection() != null){
				if(t.getCollisionDetection().checkCollision(obj.getCollisionDetection())){
					obj.getCollisionDetection().movePosition(0, -1); //moves tile back to place
					return true;
				}
			}
			
		}
		obj.getCollisionDetection().movePosition(0, -1);
		return false;
	}
	
	private boolean checkCollision(LevelObject obj, Tile[][] mapTile){
			
		ArrayList<Tile> tiles = obj.getCollisionDetection().getTiles(mapTile);
		for(Tile t: tiles){
			if(t.getCollisionDetection() != null){//checks for collision of tile
				if(t.getCollisionDetection().checkCollision(obj.getCollisionDetection())){
					return true;
				}
				
			}
		}
		return false;
	}	
}
	
	


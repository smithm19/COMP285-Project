package tantibus.physics;

import tantibus.level.Tile;
import java.util.ArrayList;

public abstract class CollisionDetection {

	public boolean checkCollision(CollisionDetection cd){
		if(cd instanceof AACollisionDetection){	
			return checkCollision((AACollisionDetection) cd);
		}
		return false;
	}
	
	public abstract boolean checkCollision(AACollisionDetection cd);
	public abstract void updatePosition(float newX, float newY);
	public abstract void movePosition(float x, float y);
	public abstract ArrayList<Tile>getTiles(Tile[][] tiles);
	public abstract ArrayList<Tile> getGroundTiles(Tile[][] tiles);
}


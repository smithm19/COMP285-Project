package tantibus.level;

import tantibus.physics.AACollisionDetection;

public class GroundTile extends Tile{

	public GroundTile(int x, int y) {
		super(x, y);
		collisionDetection = new AACollisionDetection(x*32, y*32, 32, 32);
		// TODO Auto-generated constructor stub
	}

}

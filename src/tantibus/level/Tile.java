package tantibus.level;

import tantibus.physics.CollisionDetection;

public class Tile {
	protected int x, y;
	
	protected CollisionDetection collisionDetection;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		collisionDetection = null;
	}
	
	public CollisionDetection getCollisionDetection() {
		return collisionDetection;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

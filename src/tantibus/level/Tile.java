package tantibus.level;

public class Tile {
	protected int x, y;
	//protected CollisionDetection collDetect;	//implement CollisionDetection class for this to work
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/*	implement CollisionDetection class for this to work
	public CollisionDetection getCollisionDetection() {
		return collDetect;
	}
	*/
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}

package tantibus.level;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import tantibus.character.Player;
import tantibus.enums.Gravity;

public class Level {
	private TiledMap map;
	private ArrayList<Character> characters;
	private Player player;
	private ArrayList<LevelObject> levelObjects;
	private Tile tiles;
	private Gravity gravity;
	
	public Level(String title, Player player) throws SlickException {
		//TODO with "title"
		map = new TiledMap("images/levels/"+ title + ".tmx");
		characters = new ArrayList<Character>();
		this.player = player;
		
		
	}
	
	public void loadObjects() {
		//TODO follow tutorial
	}
	
	public void addCharacters(Character ch) {
		characters.add(ch);
	}
	
	public ArrayList<Character> getCharacters() {
		return characters;
	}
	
	public void addLevelObject(LevelObject[] levelObjects) {
		//TODO follow tutorial
	}
	
	public Tile getTiles() {
		return tiles;
	}
	
	/*TODO follow tutorial
	public int getXOffset() {
		//TODO follow tutorial
	}
	*/
	
	/*TODO follow tutorial
	public int getYOffset() {
		//TODO follow tutorial
	}
	*/
	
	public void render() {
		//TODO follow tutorial
	map.render(0, 0);
	player.render(-2, -3, gravity);
	}
	
	public Gravity getGravity() {
		return this.gravity;
	}
	
	public void setGravity(Gravity newGravity) {
		this.gravity = newGravity;
	}
	
	public void backgroundRender() {
		//TODO follow tutorial
	}
}
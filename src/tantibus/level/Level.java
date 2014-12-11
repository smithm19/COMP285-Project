package tantibus.level;

// game files import
import tantibus.state.Window;
import tantibus.character.Character;
import tantibus.character.Enemy;
import tantibus.character.Player;
import tantibus.enums.Gravity;

import java.util.ArrayList;

//slick2D library import
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;



public class Level {
	
	private TiledMap map;
	
	private ArrayList<Character> characters; //list of characters
	private ArrayList<LevelObject> levelObjects;//list of objects on the map 
	private Tile[][] tiles;
	
	public Level(String title) throws SlickException {
		map = new TiledMap("images/levels/" + title + ".tmx", "images/levels");
		characters = new ArrayList<Character>(); //initializes characters (player, enemies)
		loadTileMap();
		
		levelObjects = new ArrayList<LevelObject>(); 

		loadObjects();
	}
	
	public void loadObjects() throws SlickException {
		int objectAmount = map.getObjectCount(0);
		for(int i = 0; i< objectAmount; ++i){
			switch(map.getObjectName(0, i)){
				case "Objective":
					addLevelObject(new Objective(map.getObjectX(0, i), map.getObjectY(0, i)));
					break;
			}
		}
	}
	
	private void loadTileMap(){ //objects loaded into array
		tiles = new Tile[map.getWidth()][map.getHeight()];
		int layer = map.getLayerIndex("Tile Layer 1");
		
		if(layer == -1){
			System.err.print("no Tile Layer 1r");
			System.exit(0);
		}
		
		for(int i = 0; i <map.getWidth(); ++i){
			for(int j = 0; j < map.getHeight();++j){
				int tileID = map.getTileId(i, j, layer); //get's tile
				Tile tile = null;
				
				switch(map.getTileProperty(tileID, "tileType", "solid")){//checks kind of tile (air or ground)
				case "air":
					tile = new AirTile(i, j);
					break;
				default:
					tile = new GroundTile(i, j);
					break;
				}
				tiles[i][j] = tile;
			}
		}
	}

	public void addCharacter(Character ch) {
		characters.add(ch);	
	}
	
	public ArrayList<Character> getCharacters() {
		return characters;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}

	public void addLevelObject(LevelObject object) {
		levelObjects.add(object);
	}
	
	public ArrayList<LevelObject> getLevelObjects(){
		return levelObjects;
	}
	
	
	public void render() {
		map.render(0, 0, 0, 0, 32, 18);
		
		//and then render the characters on top of the map
		for(Character c : characters) {
			c.render();
		}
	}
		
	
}

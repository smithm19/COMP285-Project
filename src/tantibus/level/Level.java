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
	private Tile[][] tiles;
	/*
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>(); //list of enemies <-- if we won't manage to figure it out, delete
	private Player player;
	private Enemy enemy;
	
	private ArrayList<LevelObject> levelObjects;//list of objects on the map 
	
	
	
	private Image background;
	*/
	
	public Level(String title) throws SlickException {
		map = new TiledMap("images/levels/" + title + ".tmx", "images/levels");
		characters = new ArrayList<Character>(); //initializes characters (player, enemies)
		loadTileMap();
		/*
		levelObjects = new ArrayList<LevelObject>(); 
		
		this.player = player;
		addCharacter(player);
		
		//
		loadObjects();
		background = new Image("images/backgrounds/" + map.getMapProperty("","background_02.jpg"));
		*/
	}
	
	/*
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
	*/
	
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
	/*
	
	public void addEnemy(Enemy e){
		enemies.add(e);
	}
	
	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	public void addLevelObject(LevelObject object) {
		levelObjects.add(object);
	}
	
	public ArrayList<LevelObject> getLevelObjects(){
		return levelObjects;
	}
	
	
	
	public int getXOffset() {
		int offsetX = 0;
		int halfWidth = (int) (Window.windowWidth/Window.scale/2);//calculates if player is in middle of screen
		int maxX = (int) (map.getWidth()*32) - halfWidth;
		
		if(player.getX() < halfWidth){
			offsetX = 0;    //player between left side of map(0) and half of screen.
		}
		else if(player.getX() >maxX){ 
			offsetX = maxX - halfWidth; //player between max scrolling point of map and min width. 
		}
		else{
			offsetX = (int) (player.getX()-halfWidth);
		}
		
		return offsetX;
	}
	
	public int getYOffset() { //same as getXOffset
		int offsetY = 0;
		int halfHeight = (int)(Window.windowHeight/Window.scale/2);
		int maxY = (int)(map.getHeight()*32) - halfHeight;
		
		if(player.getY() < halfHeight){
			offsetY = 0;
		}
		else if(player.getY() > maxY){
			offsetY = maxY - halfHeight;
		}
		else{
			offsetY = (int)(player.getY()-halfHeight);
		}
		
		return offsetY;
	}
	*/
	
	public void render() {
		map.render(0, 0, 0, 0, 32, 18);
		
		//and then render the characters on top of the map
		for(Character c : characters) {
			c.render();
		}
		
		/*
		int offsetX = getXOffset();
		int offsetY = getYOffset();
		
		
		map.render(-(offsetX%32), -(offsetY%32), offsetX/32, offsetY/32, 33, 19);
		
		for(LevelObject o: levelObjects){
			o.render(offsetX, offsetY);
		}
		for(Character ch: characters){ //render characters on top of map
			ch.render(offsetX - 20, offsetY- 100); 
		}	
		
		for(Enemy e: enemies){
			e.render(offsetX - 100, offsetY- 100);
		}
		*/
	}
		
	
}

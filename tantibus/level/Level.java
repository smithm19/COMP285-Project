package tantibus.level;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import tantibus.state.Window;
import tantibus.character.Character;
import tantibus.character.Player;
import tantibus.enums.Gravity;

public class Level {
	private TiledMap map;
	
	private ArrayList<Character> characters;
	private Player player;
	
	private ArrayList<LevelObject> levelObjects;
	
	private Tile[][] tiles;
	
	private Gravity gravity;
	private Image background;
	
	public Level(String title, Player player) throws SlickException {
		map = new TiledMap("images/levels/"+ title + ".tmx");
		characters = new ArrayList<Character>();
		
		levelObjects = new ArrayList<LevelObject>();
		
		this.player = player;
		addCharacter(player);
		
		loadObjects();
		background = new Image("images/backgrounds/" + map.getMapProperty("","background_02.jpg"));
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
	
	public void addCharacter(Character ch) {
		characters.add(ch);	
	}
	
	public ArrayList<Character> getCharacters() {
		return characters;
	}
	
	public void addLevelObject(LevelObject object) {
		levelObjects.add(object);
	}
	
	public ArrayList<LevelObject> getLevelObjects(){
		return levelObjects;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	
	public int getXOffset() {
		int offsetX =0;
		int halfWidth = (int) (Window.windowWidth/Window.scale/2);
		int maxX = (int) (map.getWidth()*32) - halfWidth;
		
		if(player.getX() < halfWidth){
			offsetX = 0;
		}
		else if(player.getX() >maxX){
			offsetX = maxX - halfWidth;
		}
		else{
			offsetX = (int) (player.getX()-halfWidth);
		}
		
		return offsetX;
	}
	
	public int getYOffset() {
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
	
	public void render() {
		
		int offsetX = getXOffset();
		int offsetY = getYOffset();
		
		//backgroundRender();
		map.render(-(offsetX%32), -(offsetY%32), offsetX/32, offsetY/32, 33, 19);
		
		for(LevelObject o: levelObjects){
			o.render(offsetX, offsetY);
		}
		for(Character ch: characters){
			ch.render(offsetX, offsetY); 
		}	
	}
	
	public Gravity getGravity() {
		return this.gravity;
	}
	
	public void setGravity(Gravity newGravity) {
		this.gravity = newGravity;
	}
	
	public void backgroundRender() {
		 float backgroundXScrollValue = (background.getWidth()-Window.windowWidth/Window.scale);
	     float backgroundYScrollValue = (background.getHeight()-Window.windowHeight/Window.scale);
	     
	     float mapXScrollValue = ((float)map.getWidth()*32-Window.windowWidth/Window.scale);
	     float mapYScrollValue = ((float)map.getHeight()*32-Window.windowHeight/Window.scale);
	     
	     float scrollXFactor = backgroundXScrollValue/mapXScrollValue * 1;
	     float scrollYFactor = backgroundYScrollValue/mapYScrollValue * -1;
	     
	     background.draw(this.getXOffset()*scrollXFactor, this.getYOffset()*scrollYFactor);
	}
}

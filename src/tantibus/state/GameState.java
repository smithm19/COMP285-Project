package tantibus.state;

import tantibus.character.*;
import tantibus.controls.Controls;
import tantibus.controls.PlayerController;
import tantibus.level.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



 class GameState extends BasicGameState {
	
	private Level level;
	
	private String startlevel;
	private Player player;
	private PlayerController controls;
	
	
	
	
	public GameState(String startLevel){
		this.startlevel = startLevel;
	}
	
	public void init (GameContainer container, StateBasedGame sbg) throws SlickException{
		player = new Player(100, 100); //need level first
		
		level = new Level(startlevel, player); //load level and character + player
		
		controls = new Controls(player); 
		
		
		//physics
	}
	
	public void update (GameContainer container, StateBasedGame sbg, int delta) throws SlickException{
		
	//	------>//controls.controlInput(container.getInput(), delta); //this causes error, don't know why, will try to figure it out later
		//physics.handlePhysics(level, delta, level.getGravity());
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException{
		
		g.scale(Window.scale, Window.scale);
		level.render();
		
	}
	
	public void keyPressed(int key, char esc){
		
		if(key == Input.KEY_ESCAPE){
			System.exit(1);
		}
	}
	public int getID() {
		
		return 0;
	}
 }
	
	
	
	

	
	





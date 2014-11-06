package tantibus.state;

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
	
	//private Level level;
	
	private String startlevel;
	//private Player player;
	//private PlayerControls controls;
	
	
	
	public GameState(String startLevel){
		this.startlevel = startLevel;
	}
	
	public void init (GameContainer container, StateBasedGame sbg) throws SlickException{
		//player = new Player(int, int); //(int, int are coordinates for player)
		
		//level = new Level(startLevel, player) //load level
		
		//playerControls = new controls(player);
		
		//physics
	}
	
	public void update (GameContainer container, StateBasedGame sbg, int delta) throws SlickException{
		
		//playerControls.ControlInput(container.getInput(), delta, level);
		//physics.handlePhysics(level, delta, level.getGravity());
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException{
		
		g.scale(Window.scale, Window.scale);
		//level.render();
		
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
	
	
	
	

	
	





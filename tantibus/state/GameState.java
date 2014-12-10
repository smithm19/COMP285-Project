package tantibus.state;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import tantibus.character.Player;
import tantibus.controls.Controls;
import tantibus.controls.PlayerController;
import tantibus.level.Level;
import tantibus.physics.Physics;



class GameState extends BasicGameState {
	
	private Level level;
	
	private String startlevel;
	private Player player;
	private Controls controls;
	private Physics physics;
	
	
	public GameState(String startLevel){
		this.startlevel = startLevel;
	}
	
	public void init (GameContainer container, StateBasedGame sbg) throws SlickException{
		player = new Player(100,100); 
		
		level = new Level(startlevel, player); //load level and character + player
		
		controls = new Controls(player); 
				
		physics = new Physics();
	}
	
	public void update (GameContainer container, StateBasedGame sbg, int delta) throws SlickException{
		
		controls.controlKeyboardInput(container.getInput(), delta);
	
		physics.controlPhysics(level, delta);
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException{
		
		g.scale(Window.scale, Window.scale);
		level.render();
		g.drawString("Tantibus ver. 0.1", 20, 20);
		
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
	
	
	
	

	
	





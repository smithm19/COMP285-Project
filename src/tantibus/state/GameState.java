package tantibus.state;

// game files import
import tantibus.character.Player;
import tantibus.controls.Controls;
import tantibus.level.Level;
/*
import tantibus.character.Enemy;
import tantibus.character.Player;
import tantibus.controls.Controls;
import tantibus.physics.Physics;
*/



import tantibus.physics.Physics;

// slick2D library import
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
	private Controls controls;
	private Physics physics;
	
	public GameState(String startLevel) {
		this.startlevel = startLevel;
		this.physics = new Physics(); //load physics
	}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		// loads the correct level for the initialized level variable
		level = new Level(startlevel);
		
		player = new Player(128, 416);
		level.addCharacter(player);
		controls = new Controls(player); //load controls
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		controls.controlKeyboardInput(container.getInput(), delta);
		physics.controlPhysics(level, delta);
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics graphics) throws SlickException {
		graphics.scale(Window.SCALE, Window.SCALE);
		level.render();
		/* graphics.drawString("Tantibus ver. 0.1", 20, 20); */
	}
	
	// this method overrides BasicGameState's method and triggers once you press any key on the keyboard
	public void keyPressed(int key, char code) {
		// closes the game if the pressed key is ESCAPE
		if(key == Input.KEY_ESCAPE) {
			System.exit(0);
		}
	}
	
	public int getID() {
		// this is the id for changing game states
		return 0;
	}
}
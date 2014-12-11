package tantibus.state;

// slick2D library import
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Window extends StateBasedGame {
	
	// sets width and height of the game window in accordance with aspect ratio
	public static final int 	WINDOW_WIDTH 	= 1280;
	public static final int 	WINDOW_HEIGHT 	= WINDOW_WIDTH / 16 * 9; // automatically adjusts to width
	public static final boolean FULLSCREEN 		= false;
	
	// base screen resolution: 1280 x 720
	// tiles: 32 x 32 size, but they are adjusted to 40 x 40 size at 1280 x 720 (aspect ratio of 1.25)
	private static final double	ASPECT_RATIO 	= 1.25;
	public static final float 	SCALE 			= (float) (ASPECT_RATIO * ((double) WINDOW_WIDTH / 1280));
	public static final String 	GAME_NAME 		= "Tantibus";
	
	public Window() {
		super(GAME_NAME);
	}

	
	public void initStatesList(GameContainer gameContainer) throws SlickException {
		// creates a game state, which does the whole logic and rendering for individual levels
		addState(new GameState("level_1"));
		this.enterState(0);
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Window());
		
		// sets the width, the height, and the fullscreen mode
		app.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, FULLSCREEN);
		app.setTargetFrameRate(60);
		
		app.start(); 
	}
		
}
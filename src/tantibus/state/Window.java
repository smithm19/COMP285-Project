package tantibus.state;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Window extends StateBasedGame{
	
	public static final int windowWidth = 800;
	public static final int windowHeight = windowWidth / 16*9; //it will adjust to window width
	public static final float scale = (float) (1.25*((double)windowWidth/800));
	public static final String GameName = "Tantibus";
	
	
	public Window() {
		
		super(GameName);
	}

	
	public void initStatesList(GameContainer arg0) throws SlickException {
		
		addState(new GameState("level 1"));
		
		this.enterState(0);
	}
	
	public static void main(String[] args) throws SlickException{
		
		AppGameContainer app = new AppGameContainer ((Game) new Window());
		
		app.setDisplayMode(windowWidth, windowHeight, false);//false = fullscreen
		app.setTargetFrameRate(60); //60 fps
		
		app.start(); 
	}
		
}
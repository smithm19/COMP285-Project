package tantibus.level;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import tantibus.enums.Gravity;
import tantibus.level.LevelObject;

public class Objective extends LevelObject{
	
	protected Animation animation;
	
	public Objective(float x, float y) throws SlickException{
		super(x, y);
		
		animation = new Animation(new Image[]{new Image("images/levels/Platformer Pack/Items/buttonBlue.png"), new Image("images/levels/Platformer Pack/Items/buttonBlue_pressed.png")}, 20);
	}


	@Override
	public void render(float offsetX, float offsetY) {
		animation.draw(x-2-offsetX, y-2-offsetY);
		
	}
}

package tantibus.controls;

import org.newdawn.slick.Input;

import tantibus.character.Player;
import tantibus.level.Level;

public abstract class PlayerController {
	protected Player player;
	
	public PlayerController(Player player) {
		this.player = player;
	}
	public abstract void controlInput(Input input, int num, Level level);
}

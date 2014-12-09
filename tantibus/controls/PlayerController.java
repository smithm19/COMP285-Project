package tantibus.controls;

import org.newdawn.slick.Input;

import tantibus.character.Player;

//Probably something in here, though it looks good.
public abstract class PlayerController {
	protected Player player;
	
	public PlayerController(Player player) {
		this.player = player;
	}
	public abstract void controlKeyboardInput(Input input, int delta);
}

package tantibus.controls;

import org.newdawn.slick.Input;

import tantibus.character.Player;
import tantibus.level.Level;
//Probably something in here, though it looks good.
public class Controls extends PlayerController {
	public Controls(Player player) {
		super(player);
	}
	
	public void controlInput(Input input, int delta) {
		//TODO follow tutorial
		controlInput(input, delta);
	}
	
	private void controlKeyboardInput(Input input, int delta) {
		if(input.isKeyDown(Input.KEY_RIGHT )||input.isKeyDown(Input.KEY_D)){
			player.movementLeft(delta);
		}
		else if(input.isKeyDown(Input.KEY_LEFT )||input.isKeyDown(Input.KEY_A)){
			player.movementRight(delta);
		}
		else{
			player.setMovement(false);
		}
		
		if(input.isKeyDown(Input.KEY_UP )||input.isKeyDown(Input.KEY_W)){
			player.jump(null);
		}
		//TODO follow tutorial
	}
}

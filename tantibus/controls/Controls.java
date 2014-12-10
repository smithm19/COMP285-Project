package tantibus.controls;

import org.newdawn.slick.Input;

import tantibus.character.Player;


public class Controls extends PlayerController{
	
	public Controls(Player player) {
		super(player);
	}
	
	public void controlInput(Input input, int delta) {
		controlKeyboardInput(input, delta);
	}
	
	public void controlKeyboardInput(Input input, int delta) {
		if(input.isKeyDown(Input.KEY_RIGHT )||input.isKeyDown(Input.KEY_D)){
			player.movementRight(delta);
		}
		else if(input.isKeyDown(Input.KEY_LEFT )||input.isKeyDown(Input.KEY_A)){
			player.movementLeft(delta);
		}
		else{
			player.setMovement(false);
		}
		
		if(input.isKeyDown(Input.KEY_UP )||input.isKeyDown(Input.KEY_W)){
			player.jump(delta);
		}
		
	}
}

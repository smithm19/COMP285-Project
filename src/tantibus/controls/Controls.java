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
	
	public void controlKeyboardInput(Input input, int delta){
		//we can both use the WASD or arrow keys to move around, obviously we can't move both left and right simultaneously
		if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)){
			player.moveLeft(delta);
		}else if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)){
			player.moveRight(delta);
		}else{
			//we don't move if we don't press left or right, this will have the effect that our player decelerates
			player.setMovement(false);
		}

		if(input.isKeyDown(Input.KEY_SPACE)){
			player.jump();
		}
	}
}

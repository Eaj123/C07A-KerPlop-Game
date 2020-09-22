package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import java.lang.Math;

public class Skeleton extends GamePiece{
	//CONSTRUCTOR

	public Skeleton(char symbol, String name, int location) {
		super(symbol, name, location);
	}
	
	
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(getLocation() - playerLocation) == 1){
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
	}
}



package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Witch extends GamePiece{
	//CONSTRUCTOR
	public Witch(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation){
			return InteractionResult.ADVANCE;
		}
		else {
			return InteractionResult.NONE;
		}
	}

}

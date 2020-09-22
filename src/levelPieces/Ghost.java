package levelPieces;

import java.util.Random;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Ghost extends GamePiece implements Moveable{
	//CONSTRUCTOR

	public Ghost(char symbol, String name, int location) {
		super(symbol, name, location);
	}
	
	Random rand = new Random(System.currentTimeMillis());


	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int random_integer = rand.nextInt(21);
		if(gameBoard[random_integer] == null) {
			int pastLocation = getLocation();
			setLocation(random_integer);
			gameBoard[random_integer]=gameBoard[pastLocation];
			gameBoard[pastLocation]=null;
		}
		else {
			move(gameBoard,playerLocation);
		}
		
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation){
			return InteractionResult.KILL;
		}
		else {
			return InteractionResult.NONE;
		}
	}

}

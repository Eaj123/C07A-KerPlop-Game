package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Zombie extends GamePiece implements Moveable{
	private boolean right = true;
	//CONSTRUCTOR

	public Zombie(char symbol, String name, int location) {
		super(symbol, name, location);
	}

//	MOVES BACK AND FORTH LIKE A GOOMBA
	public void move(Drawable[] gameBoard, int  playerLocation) {

		for(int i = 0; i < gameBoard.length;i++) {
			if(!(gameBoard[i] instanceof Zombie)) {
				continue;
			}
			if(getLocation() == 20 || getLocation() == 0) {
				right = !right;
			}
			if(right) {
				if(gameBoard[getLocation() + 1] != null) {
					right = !right;
				}
				else {
					setLocation(getLocation() + 1);
					gameBoard[getLocation()] = gameBoard[i];
					gameBoard[i] = null;
//					System.out.println("Added moveable");
					break;
				}
			}
			else {
				if(gameBoard[getLocation() - 1] != null) {
					right = !right;
				}
				else {
					setLocation(getLocation() - 1);
					gameBoard[getLocation()] = gameBoard[i];
					gameBoard[i] = null;
//					System.out.println("Added moveable");
					break;
				}
			}

		}
	}




	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(getLocation() == playerLocation) {
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
	}


}

package gameEngine;

import java.util.ArrayList;

import levelPieces.GamePiece;
import levelPieces.Ghost;
import levelPieces.Prize;
import levelPieces.Pumpkin;
import levelPieces.Skeleton;
import levelPieces.Witch;
import levelPieces.Zombie;


public class LevelSetup {

	private Drawable[] Board = new Drawable[21];
	private ArrayList<Moveable> moves = new ArrayList<Moveable>();
	private ArrayList<GamePiece> games = new ArrayList<GamePiece>();
	private final int PLAYER_START_LOCATION = 10;
	
	
	public LevelSetup(){
	}
	
	public void createLevel(int levelNum) {
		for(int i = 0;i < Board.length;i++) {
			if(Board[i] != null) {
				Board[i] = null;
			}
		}
		for(int i = 0; i < games.size();i++) {
			games.remove(0);
		}
//		Level 2  Legend:
//			  P - Player (you)
//			  X - Prize (what we are after)
//			  B - Bumble Bee (will sting you)
//			  K - Kangalo (can kill you)
//			  S - Sniper (has range but can be blocked)
		
		System.out.println("Level 1 & 2 Legend: ");
		System.out.println("G - Ghost (Can randomly kill you)");
		System.out.println("* - Prize (You want this)");
		System.out.println("P - Pumpkin (Take a rest and admire this nice pumpkin) ");
		System.out.println("S - Skeleton (Shoots anything directly next to the space it occupies)");
		System.out.println("W - Witch (Is a nice witch)");
		System.out.println("Z - Zombie (Will hit you)");

		if(levelNum == 1) {
			Board[0] = new Witch('W',"Good Witch",0);
			Board[2] = new Ghost('G',"Ghost",2);
			Board[3] = new Prize('*',"Prize",3);
			Board[8] = new Zombie('Z',"Zombie",8);
			Board[13] = new Pumpkin();
			Board[15] = new Skeleton('S',"Skeleton Archer",15);
			Board[17] = new Prize('*',"Prize",17);
		}
		else if(levelNum == 2){
			Board[0] = new Prize('*',"Prize",0);
			Board[3] = new Zombie('Z',"Zombie",3);
			Board[2] = new Ghost('G',"Ghost",2);
			Board[5] = new Pumpkin();
			Board[8] = new Skeleton('S',"Skeleton Archer",8);
			Board[14] = new Zombie('Z',"Zombie",8);
			Board[18] = new Ghost('G',"Ghost",18);
			Board[20] = new Prize('*',"Prize",20);
			Board[19] = new Witch('W',"Good Witch",19);

		}
	}

	public Drawable[] getBoard() {
		return Board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		for(int i = 0; i < Board.length;i++) {
			if(Board[i] != null && (Board[i].toString().equals("G - Ghost") ||  Board[i].toString().equals("Z - Zombie"))) {
				moves.add((Moveable)Board[i]);
//				System.out.println("Added moveable");
			}
		}
		return moves;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		for(int i = 0; i < Board.length;i++) {
			if(Board[i] != null && i != PLAYER_START_LOCATION && !(Board[i] instanceof Pumpkin)) {
				games.add((GamePiece)Board[i]);
			}
		}
		return games;
	}

	public int getPlayerStartLoc() {
		return PLAYER_START_LOCATION;
	}
}

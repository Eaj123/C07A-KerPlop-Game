package levelPieces;

import gameEngine.Drawable;

public class Pumpkin implements Drawable {
	
	public Pumpkin() {
		
	}
	
	private final char symbol = '0';
	
	public void draw() {
		System.out.print(symbol);
	}
}

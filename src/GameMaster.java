import java.util.ArrayList;

public class GameMaster {
	Board game;
	
	public GameMaster() {
		this.game = new Board();
	}
	
	//Can change to accommodate any type of chess notation for input
	//Starting assumption is "Piece location, target location"
	//For Example: "A2 A3", moving a pawn 1 space forward
	public ArrayList<int[]> parseMove(String input){
		return null;
	}
	
	//Movement Algorithm
	//1. GameMaster and parses move
	//2. GameMaster queries piece to see if move is valid
	//2.1 Does the piece belong to the active player?
	//2.2 Is the target within the piece's movement range?
	//2.3 Does making the move put the active player in check?
	//3. 
	// a. If the move is valid, the GameMaster moves the piece
	// b. Otherwise, the GameMaster requests a new move from the player
	//4. GameMaster checks for check and checkmate
	public Boolean validMove() {
		return null;
	}
	
	public Boolean findCheck() {
		return null;
	}

	public Boolean findCheckmate() {
		return null;
	}

}

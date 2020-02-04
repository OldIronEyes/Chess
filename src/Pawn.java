import java.util.ArrayList;

public class Pawn extends Piece{
	//Needed for initial 2 space move
	Boolean hasMoved;
	
	public Boolean getHasMoved() {
		return hasMoved;
	}
	
	public void setHasMoved(Boolean HasMoved) {
		this.hasMoved = HasMoved;
	}
	
	public Pawn(Boolean IsWhite, int[] Location) {
		this.setIsWhite(IsWhite);
		this.setLocation(Location);
		if(this.getIsWhite()) {
			this.setName('P');
		} else {
			this.setName('p');
		}
		this.hasMoved = false;
	}

	//Moves forward one square at a time, except on the first move where it can move 2 squares
	//Able to capture one space ahead on diagonals
	public ArrayList<int[]> getMoveset(Board board) {
		return null;
		
	}
	
	

	//If the previous player moved a pawn 2 spaces, and the current player has a pawn that
	//could have captured the opponent's if it had only moved 1 space, then the current player
	//can move their pawn diagonally and capture the pawn that moved.
	public void enPassant(int[] target) {
		
	}

}

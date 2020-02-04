import java.util.ArrayList;

public class King extends Piece {
	//Needed for castling
	Boolean hasMoved;
	
	public Boolean getHasMoved() {
		return this.hasMoved;
	}

	public void setHasMoved(Boolean HasMoved) {
		this.hasMoved = HasMoved;
	}
	
	public King(Boolean IsWhite, int[] Location) {
		this.setIsWhite(IsWhite);
		this.setLocation(Location);
		if(this.getIsWhite()) {
			this.setName('K');
		} else {
			this.setName('k');
		}
		this.hasMoved = false;
	}
	
	//Can move 1 square in any direction
	public ArrayList<int[]> getMoveset(Board board) {
		return null;
		
	}
	
	//King side, King moves to [0,6] or [7,6]
	//Queen side rook moves to [0,2] or [7,2]
	public void castling() {
		
	}
		
}

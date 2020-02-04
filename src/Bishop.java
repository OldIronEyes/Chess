import java.util.ArrayList;

public class Bishop extends Piece{
	
	public Bishop(Boolean IsWhite, int[] Location) {
		this.setIsWhite(IsWhite);
		this.setLocation(Location);
		if(this.getIsWhite()) {
			this.setName('B');
		} else {
			this.setName('b');
		}
	}

	//Moves along diagonals
	public ArrayList<int[]> getMoveset(Board board) {
		return null;
		
	}

}

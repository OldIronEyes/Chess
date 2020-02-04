import java.util.ArrayList;

public class Knight extends Piece{
	
	public Knight(Boolean IsWhite, int[] Location) {
		this.setIsWhite(IsWhite);
		this.setLocation(Location);
		if(this.getIsWhite()) {
			this.setName('K');
		} else {
			this.setName('k');
		}
	}

	//Moves 2 spaces in X or Y, then 1 space in the other dimension
	public ArrayList<int[]> getMoveset(Board board) {
		return null;
		
	}

}

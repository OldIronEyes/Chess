import java.util.ArrayList;

public class Queen extends Piece{
	
	public Queen(Boolean IsWhite, int[] Location) {
		this.setIsWhite(IsWhite);
		this.setLocation(Location);
		if(this.getIsWhite()) {
			this.setName('Q');
		} else {
			this.setName('q');
		}
	}
	
	//Moves in straight line on rows/columns or diagonally
	public ArrayList<int[]> getMoveset(Board board) {
		return null;
		
	}

}

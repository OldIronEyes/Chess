//Vijay Challa, Ronnie Jebara
//Finished, need testing
import java.util.ArrayList;

public class Bishop extends Piece{

	public Bishop(Boolean IsWhite) {
		this.setIsWhite(IsWhite);
		this.setName('b');
	}

	public ArrayList<int[]> getMoveset(Board board) {
		ArrayList<int[]> moveset = new ArrayList<int[]>();
		int[] temp = this.getLocation();
		
		//Up-Left
		for(int i = 1; (temp[0]-i > -1) && (temp[1]-i > -1); i++) {
			//Space is empty
			if(board.spaces[temp[0]-i][temp[1]-i].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]-i][temp[1]-i].getLocation());
			}
			//Space contains enemy
			else if(board.spaces[temp[0]-i][temp[1]-i].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]-i][temp[1]-i].getOccupying().getLocation());
				break;
			}
			//Space contains ally
			else if(board.spaces[temp[0]-i][temp[1]-i].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		//Up-Right
		for(int i = 1; (temp[0]-i > -1) && (temp[1]+i < 8); i++) {
			//Space is empty
			if(board.spaces[temp[0]-i][temp[1]+i].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]-i][temp[1]+i].getLocation());
			}
			//Space contains enemy
			else if(board.spaces[temp[0]-i][temp[1]+i].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]-i][temp[1]+i].getOccupying().getLocation());
				break;
			}
			//Space contains ally
			else if(board.spaces[temp[0]-i][temp[1]+i].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		//Down-Left
		for(int i = 1; (temp[0]+i < 8) && (temp[1]-i > -1); i++) {
			//Space is empty
			if(board.spaces[temp[0]+i][temp[1]-i].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]+i][temp[1]-i].getLocation());
			}
			//Space contains enemy
			else if(board.spaces[temp[0]+i][temp[1]-i].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]+i][temp[1]-i].getOccupying().getLocation());
				break;
			}
			//Space contains ally
			else if(board.spaces[temp[0]+i][temp[1]-i].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		//Down-Right
		for(int i = 1; (temp[0]+i < 8) && (temp[1]+i < 8); i++) {
			//Space is empty
			if(board.spaces[temp[0]+i][temp[1]+i].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]+i][temp[1]+i].getLocation());
			}
			//Space contains enemy
			else if(board.spaces[temp[0]+i][temp[1]+i].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]+i][temp[1]+i].getOccupying().getLocation());
				break;
			}
			//Space contains ally
			else if(board.spaces[temp[0]+i][temp[1]+i].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		return moveset;
		
	}

}
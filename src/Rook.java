//Vijay Challa, Ronnie Jebara
//Finished, need testing
import java.util.ArrayList;

public class Rook extends Piece {
	private Boolean hasMoved;

	public Boolean getHasMoved() {
		return this.hasMoved;
	}

	public void setHasMoved(Boolean HasMoved) {
		this.hasMoved = HasMoved;
	}

	public Rook(Boolean IsWhite) {
		this.setIsWhite(IsWhite);
		this.setName('R');
		this.hasMoved = false;
	}

	public ArrayList<int[]> getMoveset(Board board) {
		ArrayList<int[]> moveset = new ArrayList<int[]>();
		int[] temp = this.getLocation();
		
		//Left
		for(int i = 1; temp[1]-i > -1; i--) {
			//Space is empty
			if(board.spaces[temp[0]][temp[1]-i].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]][temp[1]-i].getLocation());
			} 
			//Space contains enemy
			else if (board.spaces[temp[0]][temp[1]-i].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]][temp[1]-i].getLocation());
				break;
			}
			//Space contains ally
			else if (board.spaces[temp[0]][temp[1]-i].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		//Right
		for(int i = 1; temp[1]+i < 8; i++) {
			//Space is empty
			if(board.spaces[temp[0]][temp[1]+i].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]][temp[1]+i].getLocation());
			}
			//Space contains enemy
			else if (board.spaces[temp[0]][temp[1]+i].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]][temp[1]+i].getLocation());
				break;
			}
			//Space contains ally
			else if (board.spaces[temp[0]][temp[1]+i].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		//Up
		for(int i = 1; temp[0]-i > -1; i--) {
			//Space is empty
			if(board.spaces[temp[0]-i][temp[1]].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]-i][temp[1]].getLocation());
			}
			//Space contains enemy
			else if (board.spaces[temp[0]-i][temp[1]].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]-i][temp[1]].getLocation());
				break;
			}
			//Space contains ally
			else if (board.spaces[temp[0]-i][temp[1]].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		//Down
		for(int i = 1; temp[0]+i < 8; i++) {
			//Space is empty
			if(board.spaces[temp[0]+i][temp[1]].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]+i][temp[1]].getLocation());
			}
			//Space contains enemy
			else if (board.spaces[temp[0]+i][temp[1]].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]+i][temp[1]].getLocation());
				break;
			}
			//Space contains ally
			else if (board.spaces[temp[0]+i][temp[1]].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		return moveset;
	}


}

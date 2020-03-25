//Vijay Challa, Ronnie Jebara
//Finished, need testing
import java.util.ArrayList;

public class Pawn extends Piece{
	Boolean hasMoved;
	
	public Boolean getHasMoved() {
		return hasMoved;
	}
	
	public void setHasMoved(Boolean HasMoved) {
		this.hasMoved = HasMoved;
	}
	
	public Pawn(Boolean IsWhite) {
		this.setIsWhite(IsWhite);
		this.setName('P');
		this.hasMoved = false;
	}

	public ArrayList<int[]> getMoveset(Board board) {
		ArrayList<int[]> moveset = new ArrayList<int[]>();
		int[] temp = this.getLocation();
		int direction;
		
		if(this.getIsWhite()) {
			direction = -1;
		} else {
			direction = 1;
		}
		
		//Normal movement and first move double
		if(board.spaces[temp[0]+direction][temp[1]].getOccupying() == null) {
			moveset.add(board.spaces[temp[0]+direction][temp[1]].getLocation());
			if(board.spaces[temp[0]+2*direction][temp[1]].getOccupying() == null && !this.hasMoved) {
				moveset.add(board.spaces[temp[0]+direction+direction][temp[1]].getLocation());
			}
		}

		//Diagonal capturing
		if(board.spaces[temp[0]+direction][temp[1]-1].getOccupying() != null && 
		   board.spaces[temp[0]+direction][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
			moveset.add(board.spaces[temp[0]+direction][temp[1]-1].getLocation());
		}
		if(board.spaces[temp[0]+direction][temp[1]-1].getOccupying() != null && 
		   board.spaces[temp[0]+direction][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
			moveset.add(board.spaces[temp[0]+direction][temp[1]+1].getLocation());
		}
		
		if(board.getEnPassant()) {
			this.enPassant(board, moveset);
		}
		
		return moveset;
	}
	
	private void enPassant(Board board, ArrayList<int[]> moveset) {
		int[] temp = this.getLocation();
		if(this.getIsWhite() && temp[0] == 3) {
			if(temp[1]-1 > -1) {
				if(board.spaces[temp[0]][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite() && Character.toLowerCase(board.spaces[temp[0]][temp[1]-1].getOccupying().getName()) == 'p') {
					moveset.add(board.spaces[temp[0]][temp[1]-1].getLocation());
				}
			}
			if(temp[1]+1 < 8) {
				if(board.spaces[temp[0]][temp[1]+1].getOccupying().getIsWhite() != this.getIsWhite() && Character.toLowerCase(board.spaces[temp[0]][temp[1]+1].getOccupying().getName()) == 'p') {
					moveset.add(board.spaces[temp[0]][temp[1]+1].getLocation());
				}
			}
		}
	}

}

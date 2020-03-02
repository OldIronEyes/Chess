//Vijay Challa, Ronnie Jebara
//Finished, need testing
import java.util.ArrayList;

public class King extends Piece {
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
		this.setName('K');
		this.hasMoved = false;
	}

	public ArrayList<int[]> getMoveset(Board board) {
		ArrayList<int[]> moveset = new ArrayList<int[]>();
		int[] temp = this.getLocation();
		
		//Up
		if(temp[0]-1 > -1) {
			if((board.spaces[temp[0]-1][temp[1]].getOccupying() == null) || (board.spaces[temp[0]-1][temp[1]].getOccupying().getIsWhite() != this.getIsWhite())) {
				moveset.add(board.spaces[temp[0]-1][temp[1]].getLocation());
			}
		}
		//Up-Right
		if((temp[0]-1 > -1) && (temp[1]+1 < 8)) {
			if((board.spaces[temp[0]-1][temp[1]+1].getOccupying() == null) || (board.spaces[temp[0]-1][temp[1]+1].getOccupying().getIsWhite() != this.getIsWhite())) {
				moveset.add(board.spaces[temp[0]-1][temp[1]+1].getLocation());
			}
		}
		//Right
		if(temp[1]+1 < 8) {
			if((board.spaces[temp[0]][temp[1]+1].getOccupying() == null) || (board.spaces[temp[0]][temp[1]+1].getOccupying().getIsWhite() != this.getIsWhite())) {
				moveset.add(board.spaces[temp[0]][temp[1]+1].getLocation());
			}
		}
		//Down-Right
		if((temp[0]+1 < 8) && (temp[1]+1 < 8)) {
			if((board.spaces[temp[0]+1][temp[1]+1].getOccupying() == null) || (board.spaces[temp[0]+1][temp[1]+1].getOccupying().getIsWhite() != this.getIsWhite())) {
				moveset.add(board.spaces[temp[0]+1][temp[1]+1].getLocation());
			}
		}
		//Down
		if(temp[0]+1 < 8) {
			if((board.spaces[temp[0]+1][temp[1]].getOccupying() == null) || (board.spaces[temp[0]+1][temp[1]].getOccupying().getIsWhite() != this.getIsWhite())) {
				moveset.add(board.spaces[temp[0]+1][temp[1]].getLocation());
			}
		}
		//Down-Left
		if((temp[0]+1 < 8) && (temp[1]-1 > -1)) {
			if((board.spaces[temp[0]+1][temp[1]-1].getOccupying() == null) || (board.spaces[temp[0]+1][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite())) {
				moveset.add(board.spaces[temp[0]+1][temp[1]-1].getLocation());
			}
		}
		//Left
		if(temp[1]-1 > -1) {
			if((board.spaces[temp[0]][temp[1]-1].getOccupying() == null) || (board.spaces[temp[0]][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite())) {
				moveset.add(board.spaces[temp[0]][temp[1]-1].getLocation());
			}
		}
		//Up-Left
		if((temp[0]-1 > -1) && (temp[1]-1 > -1)) {
			if((board.spaces[temp[0]-1][temp[1]-1].getOccupying() == null) || (board.spaces[temp[0]-1][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite())) {
				moveset.add(board.spaces[temp[0]-1][temp[1]-1].getLocation());
			}
		}
		
		if((this.getIsWhite() && board.getWhiteCanCastle()) || (!this.getIsWhite() && board.getBlackCanCastle())) {
			this.castle(board, moveset);
		}
		
		return moveset;	
	}

	private void castle(Board board, ArrayList<int[]> moveset) {
		if(this.getIsWhite()) {
			//White Queenside
			if(this.getLocation() == board.spaces[7][4].getLocation()) {
				if(board.spaces[7][1].getOccupying() == null && 
				   board.spaces[7][2].getOccupying() == null &&
				   board.spaces[7][3].getOccupying() == null &&
				  !((Rook) board.spaces[7][0].getOccupying()).getHasMoved())	{
						moveset.add(board.spaces[7][2].getLocation());
				}
			}
			
			//White Kingside
			if(this.getLocation() == board.spaces[7][4].getLocation()) {
				if(board.spaces[7][6].getOccupying() == null &&
				   board.spaces[7][5].getOccupying() == null &&
				  !((Rook) board.spaces[7][7].getOccupying()).getHasMoved()) {
						moveset.add(board.spaces[7][6].getLocation());
				}
			}
		} else {
			//Black Queenside
			if(this.getLocation() == board.spaces[0][4].getLocation()) {
				if(board.spaces[0][1].getOccupying() == null && 
				   board.spaces[0][2].getOccupying() == null &&
				   board.spaces[0][3].getOccupying() == null &&
				  !((Rook) board.spaces[0][0].getOccupying()).getHasMoved())	{
					moveset.add(board.spaces[0][2].getLocation());
				}
			}
			//Black Kingside
			if(this.getLocation() == board.spaces[0][4].getLocation()) {
				if(board.spaces[0][6].getOccupying() == null &&
				   board.spaces[0][5].getOccupying() == null &&
				  !((Rook) board.spaces[0][7].getOccupying()).getHasMoved()) {
					moveset.add(board.spaces[0][6].getLocation());
				}
			}
		}
	}

}

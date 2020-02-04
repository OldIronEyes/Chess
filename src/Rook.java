import java.util.ArrayList;

public class Rook extends Piece {
	//Needed for castling
	Boolean hasMoved;
	
	public Boolean getHasMoved() {
		return this.hasMoved;
	}

	public void setHasMoved(Boolean HasMoved) {
		this.hasMoved = HasMoved;
	}
	
	public Rook(Boolean IsWhite, int[] Location) {
		this.setIsWhite(IsWhite);
		this.setLocation(Location);
		if(this.getIsWhite()) {
			this.setName('R');
		} else {
			this.setName('r');
		}
		this.hasMoved = false;
	}
	
	//Moves in straight lines on rows or columns
	public ArrayList<int[]> getMoveset(Board board) {
		ArrayList<int[]> moveset = new ArrayList<int[]>();
		int[] temp = this.getLocation();
		
		//Horizontal Movement Left
		for(int i = (temp[1]-1); i > 0; i--) {
			//Space is empty
			if(board.spaces[temp[0]][i].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]][i].getLocation());
			} 
			//Space contains enemy
			else if (board.spaces[temp[0]][i].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]][i].getLocation());
				break;
			}
			//Space contains ally
			else if (board.spaces[temp[0]][i].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		//Horizontal Movement Right
		for(int i = (temp[1]+1); i < 7; i++) {
			//Space is empty
			if(board.spaces[temp[0]][i].getOccupying() == null) {
				moveset.add(board.spaces[temp[0]][i].getLocation());
			}
			//Space contains enemy
			else if (board.spaces[temp[0]][i].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[temp[0]][i].getLocation());
				break;
			}
			//Space contains ally
			else if (board.spaces[temp[0]][i].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		//Vertical Movement Up
		for(int i = (temp[0]+1); i < 7; i++) {
			//Space is empty
			if(board.spaces[i][temp[1]].getOccupying() == null) {
				moveset.add(board.spaces[i][temp[1]].getLocation());
			}
			//Space contains enemy
			else if (board.spaces[i][temp[1]].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[i][temp[1]].getLocation());
				break;
			}
			//Space contains ally
			else if (board.spaces[i][temp[1]].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		//Vertical Movement Down
		for(int i = (temp[0]=1); i > 0; i--) {
			//Space is empty
			if(board.spaces[i][temp[1]].getOccupying() == null) {
				moveset.add(board.spaces[i][temp[1]].getLocation());
			}
			//Space contains enemy
			else if (board.spaces[i][temp[1]].getOccupying().getIsWhite() != this.getIsWhite()) {
				moveset.add(board.spaces[i][temp[1]].getLocation());
				break;
			}
			//Space contains ally
			else if (board.spaces[i][temp[1]].getOccupying().getIsWhite() == this.getIsWhite()) {
				break;
			}
		}
		
		return moveset;
	}
	
	//King side, Rook moves to [0,5] or [7,5]
	//Queen side, Rook moves to [0,3] or [7,3]
	public ArrayList<int[]> castling(Board board, ArrayList<int[]> moveset) {
		//Can't castle after moving
		if(this.hasMoved == true) {
			return moveset;
		}
		
		//Can't castle out of check
		if(this.getIsWhite() && board.whiteInCheck) {
			return moveset;
		} else if (!this.getIsWhite() && board.blackInCheck) {
			return moveset;
		}
		
		//King hasn't moved
		if(this.getIsWhite()) {
			if(board.spaces[0][3].getOccupying().getName() == 'K') {
				
			}
		}
		
		//Black Queenside
		if(this.getLocation() == board.spaces[0][0].getLocation()) {
			
		}
		
		//Black Kingside
		if(this.getLocation() == board.spaces[0][7].getLocation()) {
			
		}
		
		//White Queenside
		if(this.getLocation() == board.spaces[0][0].getLocation()) {
			
		}
		
		//White Kingside
		if(this.getLocation() == board.spaces[0][0].getLocation()) {
			
		}
		
		return moveset;
	}

}

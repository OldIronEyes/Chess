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
		
		if((this.getIsWhite() && board.getWhiteCanCastle()) || (!this.getIsWhite() && board.getBlackCanCastle())) {
			this.castle(board, moveset);
		}
		
		return moveset;
	}

	private void castle(Board board, ArrayList<int[]> moveset) {
		if(this.getIsWhite()) {
			//White Queenside
			if(this.getLocation() == board.spaces[7][0].getLocation()) {
				if(board.spaces[7][1].getOccupying() == null && 
				   board.spaces[7][2].getOccupying() == null &&
				   board.spaces[7][3].getOccupying() == null &&
				  !((King) board.spaces[7][4].getOccupying()).getHasMoved())	{
					moveset.add(board.spaces[7][3].getLocation());
				}
			}
			
			//White Kingside
			if(this.getLocation() == board.spaces[7][7].getLocation()) {
				if(board.spaces[7][6].getOccupying() == null &&
				   board.spaces[7][5].getOccupying() == null &&
				  !((King) board.spaces[7][4].getOccupying()).getHasMoved()) {
					moveset.add(board.spaces[7][5].getLocation());
				}
			}
		} else {
			//Black Queenside
			if(this.getLocation() == board.spaces[0][0].getLocation()) {
				if(board.spaces[0][1].getOccupying() == null && 
				   board.spaces[0][2].getOccupying() == null &&
				   board.spaces[0][3].getOccupying() == null &&
				  !((King) board.spaces[0][4].getOccupying()).getHasMoved())	{
					moveset.add(board.spaces[0][3].getLocation());
				}
			}
			
			//Black Kingside
			if(this.getLocation() == board.spaces[0][7].getLocation()) {
				if(board.spaces[0][6].getOccupying() == null &&
				   board.spaces[0][5].getOccupying() == null &&
				  !((King) board.spaces[0][4].getOccupying()).getHasMoved()) {
					moveset.add(board.spaces[0][5].getLocation());
				}
			}	
		}
	}

}

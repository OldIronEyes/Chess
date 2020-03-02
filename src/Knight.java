//Vijay Challa, Ronnie Jebara
//Finished, need testing
import java.util.ArrayList;

public class Knight extends Piece{

	public Knight(Boolean IsWhite, int[] Location) {
		this.setIsWhite(IsWhite);
		this.setLocation(Location);
		this.setName('N');
	}

	public ArrayList<int[]> getMoveset(Board board) {
		ArrayList<int[]> moveset = new ArrayList<int[]>();
		int[] temp = this.getLocation();
		
		//Up
		if(temp[0]-2 > -1) {
			//Left
			if(temp[1]-1 > -1) {
				if (board.spaces[temp[0]-2][temp[1]-1].getOccupying() == null || board.spaces[temp[0]-2][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
					moveset.add(board.spaces[temp[0]-2][temp[1]-1].getLocation());
				}
			}
			//Right
			if(temp[1]+1 < 8) {
				if (board.spaces[temp[0]-2][temp[1]-1].getOccupying() == null || board.spaces[temp[0]-2][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
					moveset.add(board.spaces[temp[0]-2][temp[1]+1].getLocation());
				}
			}
		}
		
		//Down
		if(temp[0]+2 < 8) {
			//Left
			if(temp[1]-1 > -1) {
				if (board.spaces[temp[0]-2][temp[1]-1].getOccupying() == null || board.spaces[temp[0]-2][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
					moveset.add(board.spaces[temp[0]+2][temp[1]-1].getLocation());
				}
			}
			//Right
			if(temp[1]+1 < 8) {
				if (board.spaces[temp[0]-2][temp[1]-1].getOccupying() == null || board.spaces[temp[0]-2][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
					moveset.add(board.spaces[temp[0]+2][temp[1]+1].getLocation());
				}
			}
		}
		
		//Left
		if(temp[1]-2 > -1) {
			//Up
			if(temp[0]-1 > -1) {
				if (board.spaces[temp[0]-2][temp[1]-1].getOccupying() == null || board.spaces[temp[0]-2][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
					moveset.add(board.spaces[temp[0]-1][temp[1]-2].getLocation());
				}
			}
			//Down
			if(temp[0]+1 < 8) {
				if (board.spaces[temp[0]-2][temp[1]-1].getOccupying() == null || board.spaces[temp[0]-2][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
					moveset.add(board.spaces[temp[0]+1][temp[1]-2].getLocation());
				}
			}
		}
		//Right
		if(temp[1]+2 < 8) {
			//Up
			if(temp[0]-1 > -1) {
				if (board.spaces[temp[0]-2][temp[1]-1].getOccupying() == null || board.spaces[temp[0]-2][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
					moveset.add(board.spaces[temp[0]-1][temp[1]-2].getLocation());
				}
			}
			//Down
			if(temp[0]+1 < 8) {
				if (board.spaces[temp[0]-2][temp[1]-1].getOccupying() == null || board.spaces[temp[0]-2][temp[1]-1].getOccupying().getIsWhite() != this.getIsWhite()) {
					moveset.add(board.spaces[temp[0]+1][temp[1]+1].getLocation());
				}
			}
		}
		return moveset;
	}

}

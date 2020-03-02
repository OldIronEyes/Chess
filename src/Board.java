//Vijay Challa, Ronnie Jebara
//Finished, need testing

public class Board {
	Space[][] spaces;
	private Boolean whiteToMove;
	private Boolean whiteInCheck;
	private Boolean blackInCheck;
	private Boolean whiteCanCastle;
	private Boolean blackCanCastle;
	private Boolean enPassant;


	public Boolean getWhiteToMove() {
		return whiteToMove;
	}

	public void setWhiteToMove(Boolean whiteToMove) {
		this.whiteToMove = whiteToMove;
	}

	public Boolean getWhiteInCheck() {
		return whiteInCheck;
	}

	public void setWhiteInCheck(Boolean whiteInCheck) {
		this.whiteInCheck = whiteInCheck;
	}

	public Boolean getBlackInCheck() {
		return blackInCheck;
	}

	public void setBlackInCheck(Boolean blackInCheck) {
		this.blackInCheck = blackInCheck;
	}

	public Boolean getWhiteCanCastle() {
		return whiteCanCastle;
	}

	public void setWhiteCanCastle(Boolean whiteCanCastle) {
		this.whiteCanCastle = whiteCanCastle;
	}

	public Boolean getBlackCanCastle() {
		return blackCanCastle;
	}

	public void setBlackCanCastle(Boolean blackCanCastle) {
		this.blackCanCastle = blackCanCastle;
	}

	public Boolean getEnPassant() {
		return enPassant;
	}

	public void setEnPassant(Boolean enPassant) {
		this.enPassant = enPassant;
	}

	public Board() {
		this.spaces = new Space[8][8];
		int[] location = new int[2];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				location[0] = i;
				location[1] = j;
				if((i+j) % 2 == 0) {
					spaces[i][j] = new Space(null, location, ' ');
				} else {
					spaces[i][j] = new Space(null, location, '#');
				}
			}
		}
		this.populateBoard();
		this.whiteToMove = true;
		this.whiteInCheck = false;
		this.blackInCheck = false;
		this.whiteCanCastle = true;
		this.blackCanCastle = true;
		this.enPassant = false;
	}

	public Board(Board board) {
		
	}
	
	public void populateBoard() {
		
		spaces[0][0].setOccupying(new Rook(false, spaces[0][0].getLocation()));
		spaces[0][1].setOccupying(new Knight(false, spaces[0][1].getLocation()));
		spaces[0][2].setOccupying(new Bishop(false, spaces[0][2].getLocation()));
		spaces[0][3].setOccupying(new Queen(false, spaces[0][3].getLocation()));
		spaces[0][4].setOccupying(new King(false, spaces[0][4].getLocation()));
		spaces[0][5].setOccupying(new Bishop(false, spaces[0][5].getLocation()));
		spaces[0][6].setOccupying(new Knight(false, spaces[0][6].getLocation()));
		spaces[0][7].setOccupying(new Rook(false, spaces[0][7].getLocation()));
		
		for(int i = 0; i < 8; i++) {
			spaces[1][i].setOccupying(new Pawn(false, spaces[1][i].getLocation()));
			spaces[6][i].setOccupying(new Pawn(true, spaces[6][i].getLocation()));
		}
		
		spaces[7][0].setOccupying(new Rook(true, spaces[7][0].getLocation()));
		spaces[7][1].setOccupying(new Knight(true, spaces[7][1].getLocation()));
		spaces[7][2].setOccupying(new Bishop(true, spaces[7][2].getLocation()));
		spaces[7][3].setOccupying(new Queen(true, spaces[7][3].getLocation()));
		spaces[7][4].setOccupying(new King(true, spaces[7][4].getLocation()));
		spaces[7][5].setOccupying(new Bishop(true, spaces[7][5].getLocation()));
		spaces[7][6].setOccupying(new Knight(true, spaces[7][6].getLocation()));
		spaces[7][7].setOccupying(new Rook(true, spaces[7][7].getLocation()));
	}

	public void displayBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				spaces[i][j].display();
			}
			System.out.print((8 - i));
			System.out.print('\n');
		}
		System.out.println(" a  b  c  d  e  f  g  h");
	}

}

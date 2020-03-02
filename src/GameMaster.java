//Vijay Challa, Ronnie Jebara
//Finished, need testing

import java.util.ArrayList;

public class GameMaster {
	Board mainBoard;
	Board model;
	
	public GameMaster() {
		this.mainBoard = new Board();
		this.model = new Board();
	}
	
	public ArrayList<int[]> parseMove(String input){
		ArrayList<int[]> move = new ArrayList<int[]>();
		int[] piece = new int[2];
		int[] target = new int[2];
		
		if(input.charAt(0) == 'a') {
			piece[0] = 0;
		}
		if(input.charAt(0) == 'b') {
			piece[0] = 1;
		}
		if(input.charAt(0) == 'c') {
			piece[0] = 2;
		}
		if(input.charAt(0) == 'd') {
			piece[0] = 3;
		}
		if(input.charAt(0) == 'e') {
			piece[0] = 4;
		}
		if(input.charAt(0) == 'f') {
			piece[0] = 5;
		}
		if(input.charAt(0) == 'g') {
			piece[0] = 6;
		}
		if(input.charAt(0) == 'h') {
			piece[0] = 7;
		}
		piece[1] = (8 - Character.getNumericValue(input.charAt(1)));
		move.add(piece);
		
		if(input.charAt(3) == 'a') {
			target[0] = 0;
		}
		if(input.charAt(3) == 'b') {
			target[0] = 1;
		}
		if(input.charAt(3) == 'c') {
			target[0] = 2;
		}
		if(input.charAt(3) == 'd') {
			target[0] = 3;
		}
		if(input.charAt(3) == 'e') {
			target[0] = 4;
		}
		if(input.charAt(3) == 'f') {
			target[0] = 5;
		}
		if(input.charAt(3) == 'g') {
			target[0] = 6;
		}
		if(input.charAt(3) == 'h') {
			target[0] = 7;
		}
		target[1] = (8 - Character.getNumericValue(input.charAt(4)));
		move.add(target);
		
		return move;
	}

	//Turn Sequence Algorithm
	//1. GameMaster parses move
	//2. GameMaster checks if move is valid
	//2.1 Does the piece belong to the active player?
	//2.2 Is the target within the piece's movement range?
	//2.3 Does making the move put the active player in check?
	//3. 
	// a.1 If the move is valid, the GameMaster sets all relevant flags
	// a.2 GameMaster moves the piece
	// b. Otherwise, the GameMaster requests a new move from the player
	//4. GameMaster checks for check and checkmate
	public Boolean takeTurn(String input) {
		ArrayList<int[]> move = parseMove(input);
		if(!validMove(move)) {
			System.out.print("Invalid Move");
			return false;
		}
		
		movePiece(this.mainBoard, move);
		setFlags(move);
		
		return true;
	}
	
	private Boolean validMove(ArrayList<int[]> move) {
		int[] start = move.get(0);
		int[] end = move.get(1);
		
		//Does the piece belong to the active player?
		if(this.model.getWhiteToMove() != this.model.spaces[start[0]][start[1]].getOccupying().getIsWhite()) {
			return false;
		}
		
		//Is the move within the piece's moveset?
		ArrayList<int[]> moveset = this.model.spaces[start[0]][start[1]].getOccupying().getMoveset(this.model);
		for(int i = 0; i < moveset.size(); i++) {
			if(end == moveset.get(i)) {
				break;
			}
			if(i == (moveset.size()-1)) {
				return false;
			}
		}
		
		//Does making the move put the active player in check or checkmate?
		Piece piece = this.model.spaces[start[0]][start[1]].getOccupying();
		Piece target = this.model.spaces[end[0]][end[1]].getOccupying();
		
		this.model.spaces[start[0]][start[1]].setOccupying(null);
		this.model.spaces[end[0]][end[1]].setOccupying(piece);
		
		
		if(inCheck(this.model, piece.getIsWhite()) || inCheckmate(this.model, piece.getIsWhite())) {
			this.model.spaces[start[0]][start[1]].setOccupying(piece);
			this.model.spaces[end[0]][end[1]].setOccupying(target);
			return false;
		}
		
		return true;
	}

	private void setFlags(ArrayList<int[]> move) {
		int[] start = move.get(0);
		int[] end = move.get(1);
		Piece piece = this.model.spaces[start[0]][start[1]].getOccupying();
		
		//Set current turn
		if(piece.getIsWhite()) {
			model.setWhiteToMove(false);
			mainBoard.setWhiteToMove(false);
		} else {
			model.setWhiteToMove(true);
			mainBoard.setWhiteToMove(true);
		}
		
		//Piece Flags
		//Has Moved
		this.model.setEnPassant(false);
		this.mainBoard.setEnPassant(false);
		
		if(Character.toLowerCase(this.model.spaces[start[0]][start[1]].getOccupying().getName()) == 'k') {
			((King) this.model.spaces[start[0]][start[1]].getOccupying()).setHasMoved(true);
			if(piece.getIsWhite()) {
				this.model.setWhiteCanCastle(false);
				this.mainBoard.setWhiteCanCastle(false);
			} else {
				this.model.setBlackCanCastle(false);
				this.mainBoard.setBlackCanCastle(false);
			}
			
		} else if (Character.toLowerCase(this.model.spaces[start[0]][start[1]].getOccupying().getName()) == 'p') {
			((Pawn) this.model.spaces[start[0]][start[1]].getOccupying()).setHasMoved(true);
			if(start[0]+2 == end[0]) {
				this.model.setEnPassant(true);
				this.mainBoard.setEnPassant(true);
			}
			
		} else if(Character.toLowerCase(this.model.spaces[start[0]][start[1]].getOccupying().getName()) == 'r') {
			((Rook) this.model.spaces[start[0]][start[1]].getOccupying()).setHasMoved(true);
		}
		
	}
	
	private void movePiece(Board board, ArrayList<int[]> move) {
		int[] start = move.get(0);
		int[] end = move.get(1);
		Piece piece;
		
		piece = board.spaces[start[0]][start[0]].getOccupying();
		board.spaces[start[0]][start[0]].setOccupying(null);
		piece.setLocation(end);
		board.spaces[end[0]][end[1]].setOccupying(piece);
	}
	
	private void castle(Board board, ArrayList<int[]> move) {
		int[] start = move.get(0);
		int[] end = move.get(1);
		Piece rook;
		Piece king;
		
		//Black
		if(start[0] == 0) {
			king = board.spaces[0][4].getOccupying();
			board.spaces[0][4].setOccupying(null);
			//Queenside
			if(start[1] == 0 || ((start[1] == 4) && (end[1] == 2))) {
				rook = board.spaces[0][0].getOccupying();
				board.spaces[0][0].setOccupying(null);
				board.spaces[0][3].setOccupying(rook);
				board.spaces[0][2].setOccupying(king);
				king.setLocation(board.spaces[0][2].getLocation());
				rook.setLocation(board.spaces[0][3].getLocation());
			} 
			//Kingside
			else {
				rook = board.spaces[0][7].getOccupying();
				board.spaces[0][7].setOccupying(null);
				board.spaces[0][5].setOccupying(rook);
				board.spaces[0][6].setOccupying(king);
				king.setLocation(board.spaces[0][6].getLocation());
				rook.setLocation(board.spaces[0][5].getLocation());
			}
		} 
		//White
		else {
			king = board.spaces[7][4].getOccupying();
			board.spaces[7][4].setOccupying(null);
			//Queenside
			if(start[1] == 0 || ((start[1] == 4) && (end[1] == 2))) {
				rook = board.spaces[7][0].getOccupying();
				board.spaces[7][0].setOccupying(null);
				board.spaces[7][3].setOccupying(rook);
				board.spaces[7][2].setOccupying(king);
				king.setLocation(board.spaces[7][2].getLocation());
				rook.setLocation(board.spaces[7][3].getLocation());
			} 
			//Kingside
			else {
				rook = board.spaces[7][7].getOccupying();
				board.spaces[7][7].setOccupying(null);
				board.spaces[7][5].setOccupying(rook);
				board.spaces[7][6].setOccupying(king);
				king.setLocation(board.spaces[7][6].getLocation());
				rook.setLocation(board.spaces[7][5].getLocation());
			}
		}
	}
	
	private Boolean inCheck(Board board, Boolean checkWhite) {
		ArrayList<int[]> moveset;
		Boolean check = false;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(board.spaces[i][j].getOccupying().getIsWhite() != checkWhite) {
					moveset = board.spaces[i][j].getOccupying().getMoveset(this.model);
					for(int k = 0; k < moveset.size(); k++) {
						if(board.spaces[moveset.get(k)[0]][moveset.get(k)[1]].getOccupying().getIsWhite() == checkWhite &&
						   Character.toLowerCase(board.spaces[moveset.get(k)[0]][moveset.get(k)[1]].getOccupying().getName()) == 'k') {
								check = true;
						}
						if(check) {
							break;
						}
					}
				}
				if(check) {
					break;
				}
			}
			if(check) {
				break;
			}
		}
		
		return check;
	}

	private Boolean inCheckmate(Board board, Boolean checkWhite) {
		ArrayList<int[]> moveset;
		Boolean checkmate = true;
		Piece piece;
		Piece target;
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(board.spaces[i][j].getOccupying().getIsWhite() == checkWhite) {
					piece = board.spaces[i][j].getOccupying();
					moveset = board.spaces[i][j].getOccupying().getMoveset(this.model);
					for(int k = 0; k < moveset.size(); k++) {
						target = board.spaces[moveset.get(k)[0]][moveset.get(k)[1]].getOccupying();
						
						board.spaces[i][j].setOccupying(null);
						board.spaces[moveset.get(k)[0]][moveset.get(k)[1]].setOccupying(piece);
						
						checkmate = inCheck(board, checkWhite);
						
						board.spaces[i][j].setOccupying(piece);
						board.spaces[moveset.get(k)[0]][moveset.get(k)[1]].setOccupying(target);
						
						if(!checkmate) {
							break;
						}
					}
				}
				if(!checkmate) {
					break;
				}
			}
			if(!checkmate) {
				break;
			}
		}
		
		return checkmate;
	}

}

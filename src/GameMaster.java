//Vijay Challa, Ronnie Jebara

import java.util.ArrayList;

public class GameMaster {
	Board mainBoard;
	Board model;
	Board test;
	
	public GameMaster() {
		this.mainBoard = new Board();
		this.model = new Board();
		this.mainBoard.populateBoard();
		this.model.populateBoard();
		
		this.test = new Board();
	}

	public Boolean takeTurn(String input) {
		
		return false;
	}
	
	public ArrayList<int[]> parseMove(String input){
		ArrayList<int[]> move = new ArrayList<int[]>();
		String[] tokens = input.split(" ");
		
		for(int i = 0; i < tokens.length; i++) {
			move.add(parseHelper(tokens[i]));
		}
		
		return move;
	}

	private int[] parseHelper(String input) {
		int[] square = new int[2];
		
		square[0] = (8 - Character.getNumericValue(input.charAt(1)));	
		if(input.charAt(0) == 'a') {
			square[1] = 0;
		}
		if(input.charAt(0) == 'b') {
			square[1] = 1;
		}
		if(input.charAt(0) == 'c') {
			square[1] = 2;
		}
		if(input.charAt(0) == 'd') {
			square[1] = 3;
		}
		if(input.charAt(0) == 'e') {
			square[1] = 4;
		}
		if(input.charAt(0) == 'f') {
			square[1] = 5;
		}
		if(input.charAt(0) == 'g') {
			square[1] = 6;
		}
		if(input.charAt(0) == 'h') {
			square[1] = 7;
		}
		
		return square;
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

	public void debug(String input) {
		String[] spaces = input.split(" ");
		Board board = mainBoard;
		if(input.contains("main")) {
			board = mainBoard;
		} else if(input.contains("model")) {
			board = model;
		} else if(input.contains("test")) {
			board = test;
		}
		
		for(int i = 0; i < spaces.length; i++) {
			if(spaces[i].equals("dbs")) {
				dbGetSpace(board, parseHelper(spaces[i+1]));
			} else if(spaces[i].equals("dbm")) {
				dbGetMoves(board, parseHelper(spaces[i+1]));
			} else if(spaces[i].equals("dbp")) {
				dbPrintBoard(board);
			} else if (spaces[i].equals("dbsp")) {
				dbSpawnPiece(parseHelper(spaces[i+1]), spaces[i+2].charAt(0));
			}
		}
	}
	
	private void dbSpawnPiece(int[] space, char piece) {
		Boolean isWhite = Character.isUpperCase(piece);
		Piece addToBoard = null;
		if(Character.toLowerCase(piece) == 'p') {
			addToBoard = new Pawn(isWhite);
		}
		if(Character.toLowerCase(piece) == 'r') {
			addToBoard = new Rook(isWhite);
		}
		if(Character.toLowerCase(piece) == 'n') {
			addToBoard = new Knight(isWhite);
		}
		if(Character.toLowerCase(piece) == 'b') {
			addToBoard = new Bishop(isWhite);
		}
		if(Character.toLowerCase(piece) == 'k') {
			addToBoard = new King(isWhite);
		}
		if(Character.toLowerCase(piece) == 'q') {
			addToBoard = new Queen(isWhite);
		}
		test.spaces[space[0]][space[1]].setOccupying(addToBoard);
	}
	
	private void dbGetSpace(Board board, int[] space) {
		System.out.println("Requested Coordinate: " + space[0] + "," + space[1]);
		board.spaces[space[0]][space[1]].display();
		System.out.println();
		if(board.spaces[space[0]][space[1]].getOccupying() != null) {
			System.out.println("Is White: " + board.spaces[space[0]][space[1]].getOccupying().getIsWhite());
			System.out.println("Name: " + board.spaces[space[0]][space[1]].getOccupying().getName());
			System.out.println("Space Coordinate: " + board.spaces[space[0]][space[1]].getLocation()[0]
								+ "," + board.spaces[space[0]][space[1]].getLocation()[1]);
			System.out.println("Piece Coordinate: " + board.spaces[space[0]][space[1]].getOccupying().getLocation()[0]
								+ "," + board.spaces[space[0]][space[1]].getOccupying().getLocation()[1]);
			if(board.spaces[space[0]][space[1]].getOccupying().getName() == 'k'||
			   board.spaces[space[0]][space[1]].getOccupying().getName() == 'K') {
				System.out.println("Has Moved: " + ((King) board.spaces[space[0]][space[1]].getOccupying()).getHasMoved());
			}
			if(board.spaces[space[0]][space[1]].getOccupying().getName() == 'r'||
			   board.spaces[space[0]][space[1]].getOccupying().getName() == 'R') {
				System.out.println("Has Moved: " + ((Rook) board.spaces[space[0]][space[1]].getOccupying()).getHasMoved());
			}
			if(board.spaces[space[0]][space[1]].getOccupying().getName() == 'p'||
			   board.spaces[space[0]][space[1]].getOccupying().getName() == 'P') {
				System.out.println("Has Moved: " + ((Pawn) board.spaces[space[0]][space[1]].getOccupying()).getHasMoved());
			}
		}
		System.out.println();
	}
	
	private void dbGetMoves(Board board, int[] space) {
		ArrayList<int[]> moves = board.spaces[space[0]][space[1]].getOccupying().getMoveset(board);
		for(int i = 0; i < moves.size(); i++) {
			System.out.println(moves.get(i)[0] + "," + moves.get(i)[1]);
		}
	}
	
	private void dbPrintBoard(Board board) {
		board.displayBoard();
	}

	
}

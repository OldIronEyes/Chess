//Vijay Challa, Ronnie Jebara
import java.util.Scanner;

public class Chess {
	public static void main(String[] args) {
		Boolean winner = false;
		GameMaster master = new GameMaster();
		Scanner input = new Scanner(System.in);
		String move = new String();
		master.mainBoard.displayBoard();
		
		while(!winner && move != "end") {
			move = input.nextLine();
			if(move.contains("db")) {
				master.debug(move);
			} else {
				winner = master.takeTurn(move);
			}
		}
		input.close();
	}
}
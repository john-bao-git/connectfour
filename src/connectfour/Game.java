package connectfour;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board board = new Board();
		Scanner sc = new Scanner(System.in);
		int turn = 1;
		
		board.init();
		
		//Init Players
		System.out.println("Player One, please press the character you will use:");
		String sOne = sc.next();
		Player pOne = new Player(sOne);
		
		System.out.println("Player Two, please press the character you will use:");
		String sTwo = sc.next();
		while (sOne.compareToIgnoreCase(sTwo) == 0) {
			System.out.println("Please choose a character that is not the same as Player One's character.");
			System.out.println("Player Two, please press the character you will use:");
			sTwo = sc.next();
		}
		Player pTwo = new Player(sTwo);
		
		Player currPlayer = new Player("");
		
		  while (true) {
			  if (turn % 2 == 0) {
				  currPlayer = pTwo;
			  } else {
				  currPlayer = pOne;
			  }
			  
			  turn(board, currPlayer, sc);
			  if (board.checkWin()) {
				  board.printBoard();
				  System.out.printf("Player %s Wins!", currPlayer.getName());
				  System.out.println();
				  break;
			  }
			  
			  turn += 1;
		}
		 
	}
	
	private static void turn(Board b, Player p, Scanner sc) {
		b.printBoard();
		
		Piece piece = new Piece(p.getName());
		
		boolean fullColumn = true;
		String idxString;
		int idx;
		
		do {
			System.out.printf("Player %s, pick a column: ", p.getName());
			idxString = sc.next();
			
			try {
				idx = Integer.parseInt(idxString);
				if ((idx < 1) || (7 < idx)) {
					System.out.println("Invalid selection. Please try again.");
				} else {
					fullColumn = b.checkFullColumn(idx);
					if (fullColumn) {
						System.out.printf("Column %s is full. Please try again.", idx);
						System.out.println();
					} else {
						b.add(piece, idx);
					}
				}
			} catch (Exception e) {
				System.out.println("Invalid selection. Please try again.");
			}
		} while (fullColumn);
	}
}

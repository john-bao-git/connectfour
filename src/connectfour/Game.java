package connectfour;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board board = new Board();
		Scanner sc = new Scanner(System.in);
		
		board.init();
		
		//Init Players
		Player pOne = new Player("O");
		Player pTwo = new Player("X");
		
		//Do win-con
		//Do turn
		//Make a while loop for the game
	}
}

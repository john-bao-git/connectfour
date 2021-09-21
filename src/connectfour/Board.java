package connectfour;

import java.util.ArrayList;
import java.util.Stack;

public class Board {
	//Create a list of 7 stacks with height 6
	private ArrayList<Stack<Piece>> board = new ArrayList<Stack<Piece>>();
	private String[][] viewBoard = new String[6][7];
	
	public void init() {
		Stack<Piece> stackOne = new Stack<Piece>();
		Stack<Piece> stackTwo = new Stack<Piece>();
		Stack<Piece> stackThree = new Stack<Piece>();
		Stack<Piece> stackFour = new Stack<Piece>();
		Stack<Piece> stackFive = new Stack<Piece>();
		Stack<Piece> stackSix = new Stack<Piece>();
		Stack<Piece> stackSeven = new Stack<Piece>();
		
		this.board.add(stackOne);
		this.board.add(stackTwo);
		this.board.add(stackThree);
		this.board.add(stackFour);
		this.board.add(stackFive);
		this.board.add(stackSix);
		this.board.add(stackSeven);
		
		initViewBoard();
	}
	
	private void initViewBoard() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				this.viewBoard[i][j] = " ";
			}
		}
	}
	
	public void add(Piece p, int idx) {
		this.board.get(idx).push(p);
		updateViewBoard(idx, this.board.get(idx).indexOf(p), p.getName());
		printBoard();
	}
	
	private void updateViewBoard(int x, int y, String s) {
		this.viewBoard[y][x - 1] = s;
	}
	
	private void printBoard() {
		System.out.println("~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~");
		
		for (int i = 5; i >= 0; i--) {
			System.out.print("|");
			for(int j = 0; j < 7; j++) {
				System.out.print(this.viewBoard[i][j] + "|");
			}
			System.out.println();
			System.out.println("+-+-+-+-+-+-+-+");
		}
		System.out.println("|1|2|3|4|5|6|7|");
	}
}

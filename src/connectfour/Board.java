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
	
	/**
	 * 
	 * @param p			Piece
	 * @param idx		The column to place a piece on
//	 * 					Requires 1 - 
	 */
	public void add(Piece p, int idx) {
		this.board.get(idx - 1).push(p);
		updateViewBoard(idx, this.board.get(idx - 1).indexOf(p), p.getName());
	}
	
	public boolean checkFullColumn(int idx) {
		if (this.board.get(idx - 1).size() < 6) {
			return false;
		} else {
			return true;
		}
	}
	
	private void updateViewBoard(int x, int y, String s) {
		try {
			this.viewBoard[y][x - 1] = s;
		} catch (Exception e){
			System.out.printf("Y: %s | X: %s", y, x);
			System.out.println();
		}
		
	}
	
	public void printBoard() {
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~");
		System.out.println();
		
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
	
	public boolean checkWin() {
		
		/*	Different functions for every direction
		 *	Horizontal only checks Columns 1 - 4 for the starting piece
		 *	Vertical only checks Rows 1-3 for the starting piece
		 *	Diagonals use both for the starting piece
		 *		Upper Left to Lower Right checks:
		 *			Rows 1 - 3, Columns 1 - 4
		 *		Upper Right to Lower Left checks:
		 *			Rows 1 - 3, Columns 5 - 7 	
		 */
		
		return (checkWinHori() || checkWinVert() || checkWinULLR() | checkWinURLL());
	}
	
	private boolean checkWinHori() {
		// Horizontal only checks Columns 1 - 4 for the starting piece
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				String s = this.viewBoard[i][j];
				
				if (
					s.equals(this.viewBoard[i][j]) 		&& 
					s.equals(this.viewBoard[i][j + 1])	&&
					s.equals(this.viewBoard[i][j + 2])	&&
					s.equals(this.viewBoard[i][j  +3]) 	&&
					!s.equals(" ")
					) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkWinVert() {
		// Vertical only checks Rows 5 - 3 for the starting piece
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				String s = this.viewBoard[i][j];
				if (
					s.equals(this.viewBoard[i][j]) 		&& 
					s.equals(this.viewBoard[i - 1][j])	&&
					s.equals(this.viewBoard[i - 2][j])	&&
					s.equals(this.viewBoard[i - 3][j]) 	&&
					!s.equals(" ")
					) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkWinULLR() {
		/*	Diagonals use both for the starting piece
		 *		Upper Left to Lower Right checks:
		 *			Rows 3 - 5, Columns 1 - 4
		 */
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 4; j ++) {
				String s = this.viewBoard[i][j];
				if (
					s.equals(this.viewBoard[i][j]) 			&& 
					s.equals(this.viewBoard[i - 1][j + 1])	&&
					s.equals(this.viewBoard[i - 2][j + 2])	&&
					s.equals(this.viewBoard[i - 3][j + 3]) 	&&
					!s.equals(" ")
					) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkWinURLL() {
		/*	Diagonals use both for the starting piece
		 *		Upper Right to Lower Left checks:
		 *			Rows 3 - 5, Columns 5 - 7
		 */
		for (int i = 3; i < 6; i++) {
			for (int j = 3; j < 7; j ++) {
				String s = this.viewBoard[i][j];
				if (
					s.equals(this.viewBoard[i][j]) 			&& 
					s.equals(this.viewBoard[i - 1][j - 1])	&&
					s.equals(this.viewBoard[i - 2][j - 2])	&&
					s.equals(this.viewBoard[i - 3][j - 3]) 	&&
					!s.equals(" ")
					) {
					return true;
				}
			}
		}
		
		return false;
	}
}

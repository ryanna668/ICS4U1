package drawing;

import java.util.Iterator;

public class ArrayMap {
	public static void main(String[] args) {
		int  GRID = 10;
		int [][] board = new int [GRID][GRID];

		if(GRID>8) {
		board [8][2] = 99;
		}

		for(int i = 0; i<board.length ; i++) {
			board [0][i] = 10;
			board [i][0] = 10;
			board [board.length-1][i] = 10;
			board [i][board.length-1] = 10;

		}

		for(int row=0; row<GRID; row++) {
			for(int col=0; col<GRID; col++){
				System.out.printf("%3d", board[row][col]);
			}
			System.out.println();
		}
		//System.out.println("=========="); //print out dividing line of the correct length
		for (int i = 0; i < GRID*3 +2; i++) System.out.print("=");System.out.println();		
	}
}



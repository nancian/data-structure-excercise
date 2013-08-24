package Matrix;
/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

	Empty cells are indicated by the character '.'.
 */
import java.util.ArrayList;

public class Sudoku {

	public void solveSudoku(char[][] board) {
		recursion(board);
	}
	//recursion: find the first '.' and fill it with number
	private boolean recursion(char[][] board){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				if (board[i][j] == '.'){
					ArrayList<Character> list = check(board, i, j);
					if (list.size() == 0)
						return false;
					for (char c : list){
						//test by fill with c
						board[i][j] = c;
						if (recursion(board) == true)
							return true;				
					}
					//this temptation is not working, reset to '.'
					board[i][j] = '.';
					return false;
				}
			}
		}
		return true;
	}
	private ArrayList<Character> check(char[][] board, int i, int j){
		int[] exist = new int[9];
		for (int x = 0; x < 9; x++){
			char c = board[i][x];
			if ( c == '.')
				continue;
			exist[c-'1'] = 1;
		}
		for (int x = 0; x < 9; x++){
			char c = board[x][j];
			if ( c == '.')
				continue;
			exist[c-'1'] = 1;
		}

		for (int x = (i/3)*3; x < (i/3)*3+3; x++){
			for (int y = (j/3)*3; y < (j/3)*3+3; y++){
				char c = board[x][y];
				if ( c == '.')
					continue;
				exist[c-'1'] = 1;
			}
		}

		ArrayList<Character> list = new ArrayList<Character>();
		for (int m = 0; m < 9; m++){
			if (exist[m] == 0)
				list.add((char)('1'+m));
		}
		return list;

	}
}

/*
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

	Each solution contains a distinct board configuration of the n-queens' placement, 
	where 'Q' and '.' both indicate a queen and an empty space respectively.
 */
import java.util.ArrayList;


public class NQueen {
	public static void main(String[] arg){
		System.out.println(solveNQueens(4));
	}
	public static ArrayList<String[]> solveNQueens(int n) {
		ArrayList<Integer> board = new ArrayList<Integer>();
		return recurse(n, board);
	}
	//board contain solution of lines so far
	private static ArrayList<String[]> recurse(int n, ArrayList<Integer> board){
		ArrayList<String[]> list = new ArrayList<String[]>();
		//place queue at i in this line
		if (n == board.size()){
			String[] s = new String[n];
			for (int i = 0; i < n; i++){
				StringBuffer buffer = new StringBuffer();
				for (int j = 0; j < n; j++){
					if (board.get(i) == j)
						buffer.append('Q');
					else
						buffer.append('.');

				}
				s[i] = buffer.toString();
			}
			list.add(s);
		}

		for (int i = 0; i< n; i++){
			if (noAttack(i, n, board)){
				//clone is raw type, need to specify type
				@SuppressWarnings("unchecked")
				ArrayList<Integer> b = (ArrayList<Integer>)board.clone();
				b.add(i);
				list.addAll(recurse(n, b));
			}
		}
		return list;   
	} 
	private static boolean noAttack(int i, int n, ArrayList<Integer> board){
		if (board == null || board.size() == 0)
			return true;
		int x = board.size();
		
		for (int j = 0; j < board.size(); j++){
			
			if (board.get(j) == i || (board.get(j)+x-j) == i || (board.get(j)-x+j) == i)
				return false;
		}       
		return true;
	}
}

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

	For example,
	Given the following matrix:

	[
 	[ 1, 2, 3 ],
 	[ 4, 5, 6 ],
 	[ 7, 8, 9 ]
	]

	You should return [1,2,3,6,9,8,7,4,5].
 */
import java.util.ArrayList;


public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {

		if (matrix == null || matrix.length == 0){
			ArrayList<Integer> list = new ArrayList<Integer>();
			return list;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		//max loop is decided by min(m , n)
		int loop = (m > n) ? n : m;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		//i is the index of loops
		for (int i = 1; i <= (loop+1)/2; i++){
			//top line
			for (int j = i-1; j <= n-i; j++){
				list.add(matrix[i-1][j]);
			}

			//right column     
			for (int j = i; j <= m-i; j++){
				list.add(matrix[j][n-i]);
			}

			//bottom line - only when i is not the middle line
			if (2*i-1 != m){
				for (int j = n-i-1; j >= i-1; j--){
					list.add(matrix[m-i][j]);
				}
			}

			//left column
			if (2*i-1 != n){
				for (int j = m-i-1; j >= i; j--){
					list.add(matrix[j][i-1]);
				}
			}
		}
		return list;     

	}
}

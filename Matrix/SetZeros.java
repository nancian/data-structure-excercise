/*
 * Given a m x n matrix, if an element is 0, 
 * set its entire row and column to 0. Do it in place.
 */
public class SetZeros {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		//if row1 and col1 should be all 0s
		boolean row1 = false;
		boolean col1 = false;
		for (int i = 0; i < n; i++)
			if (matrix[0][i] == 0)
				row1 = true;
		for (int i = 0; i < m; i++){
			if (matrix[i][0] == 0)
				col1 = true;
		}
		//use row1 and col1 to store if the col/row should be all 0s
		for(int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				if (matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		//set cells except row1 and col1
		for(int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				if (matrix[0][j] == 0 || matrix[i][0] == 0)
					matrix[i][j] = 0;
			}
		}
		//set row1
		if (row1 == true){
			for (int i = 0; i< n; i++){
				matrix[0][i] = 0;
			}
		}
		//set col1
		if (col1 == true){
			for (int i = 0; i< m; i++){
				matrix[i][0] = 0;
			}
		}
	}
}

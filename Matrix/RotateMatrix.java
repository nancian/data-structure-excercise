package Matrix;
import java.util.Arrays;


public class RotateMatrix {
	public static void main (String[] arg){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		System.out.print(Arrays.toString(matrix[0]) + Arrays.toString(matrix[1]) + Arrays.toString(matrix[2]));
	}
	/*
	 * rotate in-place
	 */
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n == 0 || n == 1)
			return;
		//rotate top left corner 
		for (int i = 0; i <= (n-1)/2; i++){
			for (int j = 0; j <= (n-1)/2; j++){
				//if n is odd, rotate the middle column only once
				if (2*j+1 != n){
					int tmp = matrix[i][j];
					matrix[i][j] = matrix[n-1-j][i];
					matrix[n-1-j][i]= matrix[n-1-i][n-1-j];
					matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
					matrix[j][n-1-i] = tmp;
				}
			}
		}
	}
}

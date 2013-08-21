package Matrix;

public class UniqueWaysMatrix {
	/*
	 * DP with recursion
	 */
	public int uniquePaths(int m, int n) {
		//m, n could be 100
		int[][] record = new int[101][101];
		return recurse(m,n,record);
	}
	private int recurse(int m, int n, int[][] record){
		if (m == 0 || n == 0){
			return 0;
		}
		if (m == 1 || n == 1){
			return 1;
		}
		if (record[m][n] != 0){
			return record[m][n];
		}
		else{
			record[m][n] = recurse(m-1,n,record)+recurse(m,n-1,record);
			return record[m][n];
		}
	}
	/*
	 * iterative
	 */
	public static int uniquePaths2(int n, int m){
		int[][] A = new int[n][m];
		A[0][0] = 1;
		for (int i = 0; i<n; i++)
			for(int j = 0; j<m; j++){
				if (i>0) A[i][j] = A[i-1][j];
				if (j>0) A[i][j] += A[i][j-1];
			}
		return A[n-1][m-1];
	}
}

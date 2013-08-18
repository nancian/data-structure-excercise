
public class twoDRecursive {
	public static void main(String[] arg){
		System.out.println(recurse(3,4));
	}
	public static int recurse(int n, int m){
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

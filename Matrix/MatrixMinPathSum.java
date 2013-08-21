package Matrix;
/*
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.
 */
public class MatrixMinPathSum {
	/*
	 * iterative solution
	 */
	
	/*
	 * with DP solution
	 */
	 public int minPathSum(int[][] grid) {
	        int m = grid.length;
	        int n = grid[0].length;
	        if (grid == null || m == 0 || n == 0)
	            return 0;
	        else{
	            int[][] result = new int[m][n];
	            return recurse(grid, m-1, n-1, result);
	        }
	        
	    }
	    private int recurse(int[][] grid, int i, int j, int[][] result){
	        if (i == 0 && j == 0)
	            return grid[0][0];
	        if (result[i][j] != 0){
	            return result[i][j];
	        }
	        if (i == 0){
	            result[i][j] = recurse(grid, i, j-1,result)+grid[i][j];
	        }
	        else if (j == 0){
	            result[i][j] = recurse(grid, i-1, j, result)+grid[i][j];
	        }
	        else{
	            result[i][j] = Math.min(recurse(grid, i, j-1,result),recurse(grid, i-1, j,result))+grid[i][j];
	        }
	        return result[i][j];
	            
	    }
	/*
	 * recursive solution(without dp)
	 */
	public int minPathSum2(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		else
			return recurse(grid, grid.length-1, grid[0].length-1);

	}
	private int recurse(int[][] grid, int i, int j){
		if (i == 0 && j == 0)
			return grid[0][0];
		if (i == 0)
			return recurse(grid, i, j-1)+grid[i][j];
		if (j == 0)
			return recurse(grid, i-1, j)+grid[i][j];
		else
			return Math.min(recurse(grid, i, j-1),recurse(grid, i-1, j))+grid[i][j];


	}
}


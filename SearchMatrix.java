/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		if (target < matrix[0][0] || target > matrix[m-1][n-1])
			return false;
		int low = 0;
		int high = m-1;
		int mid = 0;
		while (low <= high){
			mid = (low+high)/2;
			if (matrix[mid][0] == target)
				return true;
			else if(matrix[mid][0] < target && (mid == matrix.length-1 || matrix[mid+1][0] > target)){
				break;
			}
			else if(matrix[mid][0] < target){
				low = mid+1;
			}
			else
				high = mid-1;
		}

		low = 0;
		high = n-1;
		int middle = 0;
		while (low<=high){
			middle = (low+high)/2;
			if (matrix[mid][middle] == target)
				return true;
			if (matrix[mid][middle] < target)
				low = middle+1;
			else
				high = middle-1;
		}
		return false;
	}
}

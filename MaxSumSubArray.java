/*
 *  Find the contiguous sub array within an array (containing at least one number) which has the largest sum.

	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
	the contiguous sub array [4,−1,2,1] has the largest sum = 6.
 */
public class MaxSumSubArray {
	public int maxSubArray(int[] A) {
		//maximum sum ending at i
		int sum = 0;
		//maximum sum so far
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++){
			if (sum < 0)
				sum = A[i];
			else
				sum += A[i];
			if (sum > max)
				max = sum;
		}
		return max;
	}
}

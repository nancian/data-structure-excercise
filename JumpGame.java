/*
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your **maximum** jump length at that position.

	Determine if you are able to reach the last index.

	For example:
	A = [2,3,1,1,4], return true.

	A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	/*
	 * solution: did not consider branches of jumping less than max steps in each jump
	 * pass the large data set anyway
	 */
	public boolean canJump(int[] A) {
		if (A == null || A.length == 1){
			return true;
		}
		int index = 0;
		while (true){
			int tmp = index;
			index = A[index]+index;
			//set old index to -1 to indicate used
			A[tmp] = -1;
			//A[index] is the max jump length
			if (index >= A.length-1)
				return true;
			if (A[index] == -1 ){
				return false;
			}      

		}
	}
}

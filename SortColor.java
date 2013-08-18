/*
 *  Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 *  with the colors in the order red, white and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

	Note:
	You are not suppose to use the library's sort function for this problem.

	Follow up:
	A rather straight forward solution is a two-pass algorithm using counting sort.
	First, iterate the array counting number of 0's, 1's, and 2's, 
	then overwrite array with total number of 0's, then 1's and followed by 2's.

	Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColor {
	public void sortColors(int[] A) {
        if(A.length <= 1) return;
        int i = 0,j = A.length-1;
        int cur = i;
        while(cur <= j) {
            //if 0, swap with i(elements before i are all 0)
            if(A[cur] == 0) {
                if(cur > i) {
                    swap(A, i,cur);
                    i++;
                } else {
                    ++cur;
                    ++i;
                }
            //if 2, swap with j(elements after j are all 2)
            } else if (A[cur] == 2) {
                if(cur < j){
                    swap(A,j,cur);
                    j--;
                }
                else 
                    return;
            } 
            //if 1, continue
            else 
                ++cur;
        }
    }
    private void swap(int[] A, int x, int y){
        int tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
    }
}

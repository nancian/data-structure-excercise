/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int a = m-1;
		int b = n-1;
		int index = A.length-1;
		//including the scenario n = 0
		while (b >= 0){
			//consider m could be 0
			if (a < 0 || A[a] < B[b]){
				A[index] = B[b];
				b--;
			}         
			else{
				A[index] = A[a];
				a--;
			}

			index--;

		}
	}
}

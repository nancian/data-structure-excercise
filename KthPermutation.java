/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

Given n and k, return the kth permutation sequence.
 */
public class KthPermutation {
	public String getPermutation(int n, int k) {
		int[] perm = new int[n];
		int[] visit = new int[n];
		perm[0] = 1;
		for (int i = 1; i < n; i++){
			perm[i] = perm[i-1]*i;
		}
		//k should start from 0, not 1
		k = k-1;

		StringBuffer s = new StringBuffer();
		for (int i = n-1; i > 0; i--){
			int a = k/perm[i];
			//modify k before a changes
			k = k-a*perm[i];
			int j = 0;
			for (; j < n; j++){
				if (visit[j] == 0){
					a--;
					if (a < 0)
						break;
				}
			}
			//j should not be local to for loop
			visit[j] = 1;
			s.append(Integer.toString(j+1));

		}
		int j = 0;
		for (; j < n; j++){
			if (visit[j] == 0){
				break;
			}
		}
		s.append(Integer.toString(j+1));
		return s.toString();
	}
}

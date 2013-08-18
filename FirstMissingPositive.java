/***

Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space(not linear).

寻找数组中第一个未出现的正整数，题目本身比较常见，关键在于题目要求只能使用常数额外空间。
A:

虽然不能再另外开辟非常数级的额外空间，但是可以在输入数组上就地进行swap操作。

思路：交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。

*/
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        while(i < A.length){
            //A[i] == i+1  ==  A[A[i]-1] = A[i]
            if (A[i] != (i+1) && A[i] > 0 && A[i] <= A.length && A[A[i]-1] != A[i]){
                int tmp = A[i];
                A[i] = A[tmp-1];
                A[tmp-1] = tmp;
            }
            else{
                i++;
            }
        }
        for (int j = 0; j < A.length; j++){
            if (A[j] != (j+1))
                return (j+1);
        }
        return A.length+1;
    }
}
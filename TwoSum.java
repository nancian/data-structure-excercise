/* 
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

 * takes O(nlogn) time and O(n) space
 * instead of hashmap, create a new class that contain a key and value
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
public class twoSum {
	public static void main(String[] args){
		int[] input = {5,75,25};
		//int [] input = new int[2];
		System.out.println(Arrays.toString(twoSum2(input, 100)));
	}
	public static int[] twoSum2(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		final HashMap<Integer, Integer> tsum = new HashMap<Integer, Integer>();
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++){
			tsum.put(i, numbers[i]);
			sorted.add(i);
		}
		//sort index array by value
		Collections.sort(sorted, new Comparator<Integer>(){
			public int compare(Integer n1, Integer n2){
				return tsum.get(n1).compareTo(tsum.get(n2));
			}
		});

		//get index
		int low = 0;
		int high = sorted.size() - 1;
		while(low < high){
			if (tsum.get(sorted.get(low)) + tsum.get(sorted.get(high)) == target)
				break;
			if (tsum.get(sorted.get(low)) + tsum.get(sorted.get(high)) < target)
				low = low + 1;
			else{
				high = high -1;
			}

		}

		if (low >= high)//no result exist
			return null;
		else{
			//index1 should be lower than index2
			if (sorted.get(low) < sorted.get(high)){
				int[] result = {sorted.get(low)+1, sorted.get(high)+1};
				return result;
			}
			else{
				int[] result = {sorted.get(high)+1, sorted.get(low)+1};
				return result;
			}
		}


	}
}

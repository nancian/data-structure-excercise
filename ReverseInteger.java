/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

 * should consider overflow of integer(not considered in following answer), and negative numbers
 */

import java.util.LinkedList;


public class reverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}
	public static int reverse(int x) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		int tmp = x;
		if (x < 0)
			tmp = tmp * (-1);
		
		while(tmp >= 1){
			l.add(tmp%10);
			tmp = tmp/10;
			
		}
		int result = 0;
		for(int i = 0; i < l.size(); i++){
			result = (result + l.get(i))*10;
			//System.out.println(result);
		}
		if (x < 0)
			result = result * (-1);
		return result/10;
	}
}

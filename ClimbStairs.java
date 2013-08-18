/*
 * Dynamic Programming
 * You are climbing a stair case. It takes n steps to reach to the top.

	Each time you can either climb 1 or 2 steps. 
	In how many distinct ways can you climb to the top?
 */
public class ClimbStairs {
	public int climbStairs(int n) {
		int[] steps = new int[n+1];
		return recurse(n, steps);
	}
	private int recurse(int n, int[] steps){
		if (n == 0 || n == 1)
			return 1;
		//use cached result
		if (steps[n] != 0)
			return steps[n];
		else{

			return steps[n] = recurse(n-1, steps)+recurse(n-2,steps);
		}
	}
}

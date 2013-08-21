
/**
 * calculate pow(x,n)
 */

import java.util.ArrayList;
public class PowerOfX {
	public static void main(String[] arg){
		System.out.println(pow(0.00001,2147483647));
	}
	/*
	 * solution1: divide n as sum of (2^i)
	 */
    public static double pow(double x, int n){
		//x^(2^index)
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(x); 
		//overflow of (1<<i)!!!
		for (int i = 1; (1<<i) <= Math.abs(n) && (1<<i) > 0; i++){
			System.out.println(i + "" + (1<<i));
			list.add(list.get(i-1)*list.get(i-1));
		}
       
       double result=1;
       int absn = Math.abs(n);
		for (int i = 0; absn != 0; i++){
			int digit = absn % 2;
			absn = absn/2;
			if (digit == 1)
               result *= list.get(i);
		} 
       //n could be negative
       if (n < 0)
           result = 1/result;
		return result;
	}
    /*
     * solution2: no extra space
     */
    public double pow2(double x, int n) {
        
        double result=1;
        double pre = x;
        int absn = Math.abs(n);
 		for (int i = 0; absn != 0; i++){
 			int digit = absn % 2;
 			absn = absn/2;
 			if (digit == 1)
                result *= pre;
             pre = pre*pre;
             if (result == 0)
                 return result;
 		} 
        //n could be negative
        if (n < 0)
            result = 1/result;
 		return result;
         
     }
}

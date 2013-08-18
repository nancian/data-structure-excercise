/*
 *  Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * 
 * bad solution: need more polish
 */
public class decodeWays {
    public int numDecodings(String s) {
        
        if (s == null || s.length() == 0)
            return 0;
        else{
            int[] dp = new int[s.length()];
            int result = recurse(s, s.length()-1, dp);
            if (result == -1)
                return 0;
            else
                return result;
        }
    }
    
    private int recurse(String s, int i, int[] dp){   
        //base case
        if (i == -1)
            return 1;
        if (i == 0 && s.charAt(i) != '0')
            return 1;
        
        else if(dp[i] != 0)
            return dp[i];
        else if(s.charAt(i) == '0'){
            if (i != 0 && (s.charAt(i-1) == '1' || s.charAt(i-1)=='2')){
                int tmp = recurse(s,i-2,dp);
                if (i>1)
                    dp[i-2] = tmp;
                dp[i] = tmp;
                
            }
            else
                dp[i] = -1;
            return dp[i];
        }
        
        else{
            //substring(begin, end+1)
            
            if (Integer.parseInt(s.substring(i-1,i+1)) <= 26 && s.charAt(i-1) != '0'){
                
                dp[i] = recurse(s,i-2,dp);
                
            }
            
            dp[i] += recurse(s,i-1,dp);
            
            if (i>0 && dp[i-1] < 0)
                return -1;
            return dp[i]; 
             
        }
            
    
    }
}

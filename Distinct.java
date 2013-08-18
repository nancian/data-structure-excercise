/**
 *  Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*******************************
 * best efficient: loops + dp
 * example: aab ab
 *       a  b
 *    ---------  
 *  a |  1  - 
 *  a |  2  0
 *  b |  2  2
 * public class Solution {  
        public int numDistinct(String S, String T) {  
              
            int l=S.length(),m=T.length();  
            if(m==0||l==0) return 0;  
            int dp[][]=new int[l][m];
            //go through s  
            for(int i=0;i<l;i++){  
            	//go through only j<=i(no possible match after j>i)
                for(int j=0;j<=Math.min(i,m-1);j++){  
                    if(S.charAt(i)==T.charAt(j)){ 
                     	//if first match of s and t, return 1
                     	//else, same as last
                        dp[i][j]=(i==0||j==0)?1:dp[i-1][j-1];  
                    }  
                    //if i==j(same sequence before i or no match), add nothing
                    //else, add ones match T[j] before i
                    dp[i][j]+=((i==j)?0:dp[i-1][j]);  
                      
                }  
            }  
              
            return dp[l-1][m-1];  

        }  
    }  
 * 
 * 
 * 
 * @author QIAN
 * more efficient solution: 2-D array + recursion
 * DP: let F(i, j) denote the number of ways for S[0]…S[i] contain T[0]..T[j], Then F(n-1, m-1) is our answer and we have
 * if(S[i] != T[j])  F(i, j) = F(i-1, j);
 * if(S[i] == T[j]) F(i, j) = F(i-1, j-1) + F(i-1, j);
 */
public class Distinct {
   public static int numDistinct(String S, String T) {
       int[][] mat = new int[S.length()][T.length()];
        if (S.length() == 0 || T.length() == 0)
            return 0;
        else
            return recurse(S, T, 0, 0, mat);
        
    }
    
    private static int recurse(String S, String T, int s, int t, int[][] mat){
        //System.out.println("s:"+s+" t:"+t);
        if (S.charAt(s) == T.charAt(t)){
            //end of s and end of t: return 1
            if (s == S.length()-1 && t == T.length()-1)
                return 1;
            //end of s but not end of t: no match
            if(s == S.length()-1)
                return 0;
            //if cached
            if (mat[s][t] != 0)
                return mat[s][t];
            //end of t but not end of s: match! but may be more match for last char
            if (t == T.length()-1){
                mat[s][t] = 1 + recurse(S, T, s+1, t, mat);
                return mat[s][t];
            }
            //no end of t or s: continue searching
            else{
                mat[s][t] =  recurse(S, T, s+1, t+1, mat)+recurse(S, T, s+1, t, mat);
                return mat[s][t];
            }
        }
        else{
            //
            if (s == S.length()-1)
                return 0;
            if (mat[s][t] != 0)
                return mat[s][t];
            else{
                mat[s][t] = recurse(S, T, s+1, t, mat);
                return mat[s][t];
            }
        }
    }
}

/* not DP solution:
 
public class Distinct {
    public static void main(String[] args) {
        // Start typing your code here...
        System.out.println(numDistinct("rabbbit","rabbit"));
        
        
    }
    public static int numDistinct(String S, String T) {
        if (S.length() == 0 || T.length() == 0)
            return 0;
        else
            return recurse(S, T, 0, 0);
        
    }
    
    private static int recurse(String S, String T, int s, int t){
        System.out.println("s:"+s+" t:"+t);
        if (S.charAt(s) == T.charAt(t)){
            //end of s and end of t: return 1
            if (s == S.length()-1 && t == T.length()-1)
                return 1;
            //end of s but not end of t: no match
            if(s == S.length()-1)
                return 0;
            //end of t but not end of s: match! but may be more match for last char
            if (t == T.length()-1)
                return 1 + recurse(S, T, s+1, t);
            //no end of t or s: continue searching
            else
                return recurse(S, T, s+1, t+1)+recurse(S, T, s+1, t);
                
        }
        else{
            //
            if (s == S.length()-1)
                return 0;
            else
                return recurse(S, T, s+1, t);
        }
    }
}
*/

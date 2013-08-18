package string;
/*
 * Longest Substring Without Repeating CharactersMay 16 '117839 / 23728

Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */

import java.util.Arrays;
import java.util.HashMap;
public class longestSubstring {
	public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int[] table = new int[256];
        int start = 0;
        Arrays.fill(table, -1);
        for (int i = 0; i< s.length(); i++){          
            if(table[s.charAt(i)] >= start){      
                if ((i-start) > max)
                    max = i-start;              
                start = table[s.charAt(i)]+1;
            }
            //edge case!! if end of string...
            else{
                if(i == s.length()-1)
                    max = max > (i-start +1) ? max:(i-start+1);
            }
            table[s.charAt(i)] = i;           
        }
        return max;
    }
}

/*time: O(n*n)
public class longestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> alpha = new HashMap<Character, Integer>();
		//int length = 0;
		int max = 0;
		int start = 0;
		char[] str = s.toCharArray();
		//System.out.println(Arrays.toString(str));
		for (int i = 0; i < str.length; i++ ){
			if (alpha.containsKey(str[i])){
				int index = alpha.get(str[i]);
				//System.out.println("dup: " + index + i);
				//length = i - index;
				int j = index;
				while ( j >= start){
					alpha.remove(str[j]);
					//System.out.println("-del: " + index);
					j--;
				}
				start = index + 1;
				alpha.put(str[i], i);
			}
			else{
				//System.out.println("+add: " + i);
				alpha.put(str[i],i);
				//length++;
				if (alpha.keySet().size() > max){
					max = alpha.keySet().size();
					//System.out.println("max: " + max);
				}
			}


		}
		return max;
	} 
	
	/*
	 *  HashMap<Charactor, LinkedList<Integer>> table = new HashMap<Charactor, LinkedList<Integer>>();
        for(int i  = 0; i < S.length(); i++){
            if (table.containsKey(S.charAt(i))){
                table.get(S.charAt(i)).add(i);
            }
            else{
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.add(i);
                table.put(S.charAt(i),list);
            }
        } 
	 
}*/
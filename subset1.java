/*
 *  Given a set of distinct integers, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
 */
import java.util.Arrays;
import java.util.ArrayList;

public class subset1 {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {   
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(S);
        ArrayList<Integer> empty = new ArrayList<Integer>();
        result.add(empty);
        for(int i = 0; i < S.length; i++){
            int size = result.size(); 
            for(int j=0; j<size; j++){
                //need to specify the type, clone() returns object
                 ArrayList<Integer> list =(ArrayList<Integer>) result.get(j).clone();
                 list.add(S[i]);
                 result.add(list);
                 }
        
        }
        return result;
    }
} 
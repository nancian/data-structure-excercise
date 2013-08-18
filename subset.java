/*
 *  Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
 */
//pay attention to import
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
public class subset {
	public static void main(String[] args) {
		// Start typing your code here...
		int[] t = {-1,1,1,1,2};
		//subsetsWithDup(t);
		ArrayList<ArrayList<Integer>> result = subsetsWithDup(t);
		for (int i = 0; i < result.size(); i++){
			//Arrays.toString()only works for array
			System.out.println(i+": "+result.get(i));
		}
	}

	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {       
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		//initiate the hash table by count of elements
		for (int i = 0; i < num.length; i++){
			if(table.containsKey(num[i])){
				int count = table.get(num[i]);
				//++count!!
				table.put(num[i],++count);
			}
			else
				table.put(num[i],1);
		}
		System.out.println(table);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Set<Integer> keys = table.keySet();
		//set to array list!!!
		ArrayList<Integer> k = new ArrayList<Integer>(keys);
		//collection can only sort list
		Collections.sort(k);
		//iterator!!
		Iterator<Integer> itr = k.iterator();

		//when do iterator.next(), iterator will point to the next element
		while(itr.hasNext()){

			int index = 0;
			//next()!
			int element = (Integer)itr.next();
			
			//cannot add size of result and index at the same time
			
			int size = result.size();
			while(size > index){

				ArrayList<Integer> cp = (ArrayList<Integer>)result.get(index).clone();
				cp.add(element);
				result.add(cp);
				//System.out.println("cp:"+cp);
				for(int j = 1; j < table.get(element); j++){
					//need to specify clone type
					cp = (ArrayList<Integer>)cp.clone();
					cp.add(element);
					result.add(cp);
					//System.out.println("cpcp:"+cpcp);
				}
				index++;
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(element);
			result.add(list);
			//System.out.println("list:"+list+" count:"+table.get(element));
			//
			for(int j = 1; j < table.get(element); j++){
				list = (ArrayList<Integer>)list.clone();
				list.add(element);
				result.add(list);
				//System.out.println("listcp:"+listcp);
			}
			/* debug *
			for (int i = 0; i < result.size(); i++){
				//Arrays.toString()only works for array
				System.out.println(i+": "+result.get(i));
			}
			System.out.println("---------------------");
			*/
		}
		//empty one!
		ArrayList<Integer> empty = new ArrayList<Integer>();
		result.add(empty);
		return result;

	}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class PermutationDups {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		if (num == null)
			return null;
		HashMap<Integer, LinkedList<Integer>> table = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 0; i< num.length; i++){
			if (!table.containsKey(num[i])){
				LinkedList<Integer> l = new LinkedList<Integer>();
				l.add(i);
				table.put(num[i],l);
			}
		}
		return recurse(num, num.length-1, table);
	}
	private ArrayList<ArrayList<Integer>> recurse(int[] num, int n, HashMap<Integer, LinkedList<Integer>> table){
		if (n == 0){
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(num[0]);
			list.add(l);
			return list;
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> preList = recurse(num, n-1, table);
		for (int i = 0; i< preList.size(); i++){
			ArrayList<Integer> l = preList.get(i);
			l.add(num[n]);
			list.add(l);
			for (int j = 0; j < l.size()-1; j++){
				if (table.get(num[n]) == null);
					ArrayList<Integer> tmp = (ArrayList<Integer>)l.clone();
				swap(tmp, j, l.size()-1);
				list.add(tmp);
			}
		}
		return list;
	}
	
	private void swap(ArrayList<Integer> l, int i, int j){
		int tmp = l.get(i);
		l.set(i, l.get(j));
		l.set(j, tmp);
	}
}

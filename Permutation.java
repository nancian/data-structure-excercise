/**
 * Given a collection of numbers, return all possible permutations.

	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]

 */
import java.util.ArrayList;

public class Permutation {
	/*
	 * solution 1: recursive
	 */
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		if (num == null)
			return null;
		return recurse(num, num.length-1);
	}
	private ArrayList<ArrayList<Integer>> recurse(int[] num, int n){
		if (n == 0){
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(num[0]);
			list.add(l);
			return list;
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> preList = recurse(num, n-1);
		for (int i = 0; i< preList.size(); i++){
			ArrayList<Integer> l = preList.get(i);
			for (int j = 0; j <= l.size(); j++){
				@SuppressWarnings("unchecked")
				ArrayList<Integer> tmp = (ArrayList<Integer>)l.clone();
				tmp.add(j, num[n]);
				list.add(tmp);
			}
		}
		return list;
	}
	/*
	 * another solution: no 
	 */
	public ArrayList<ArrayList<Integer>> permute2(int[] num) {  
		  
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
		ArrayList<Integer> tmp = new ArrayList<Integer>();  
		int n = num.length;  
		boolean[] visited = new boolean[n];  

		permuteImp2(res, tmp, num, visited);  

		return res;  
	}  
	private void permuteImp2(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, boolean[] visited){  
		if(tmp.size() == num.length){  
			res.add(new ArrayList<Integer>(tmp));  
			return;  
		}  
		for(int i=0; i<num.length; i++){  
			if(!visited[i]){  
				tmp.add(num[i]);  
				visited[i] = true;  
				permuteImp2(res, tmp, num, visited);  
				visited[i] = false;  
				tmp.remove(tmp.size()-1);  
			}  
		}  

	}
}

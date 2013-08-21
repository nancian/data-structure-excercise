import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.

	For example,
	Given [1,3],[2,6],[8,10],[15,18],
	return [1,6],[8,10],[15,18].
  */
 

public class MergeIntervals {
	/*
	 * Solution: sort by start time, then merge with next interval
	 */
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() == 1){
			return intervals;
		}
		//usage of Comparator!!
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.start - b.start;
			}
		});
		for (int i = 1; i < intervals.size(); i++){
			if (intervals.get(i-1).end >= intervals.get(i).start){
				intervals.get(i-1).end = (intervals.get(i-1).end > intervals.get(i).end) ? (intervals.get(i-1).end) : (intervals.get(i).end);

				intervals.remove(i);
				i--;
			}
		}
		return intervals;

	}
	/*
	 * wrong solution: only merge with next intervals, won't work if not sorted
	 */
	public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() == 1){
			return intervals;
		}

		for (int i = 1; i < intervals.size(); i++){
			if ((intervals.get(i-1).start <= intervals.get(i).start && intervals.get(i-1).end >= intervals.get(i).start)
					|| (intervals.get(i-1).start > intervals.get(i).start && intervals.get(i).end >= intervals.get(i-1).start)){
				intervals.get(i-1).end = (intervals.get(i-1).end > intervals.get(i).end) ? (intervals.get(i-1).end) : (intervals.get(i).end);
				intervals.get(i-1).start = (intervals.get(i-1).start < intervals.get(i).start) ? (intervals.get(i-1).start) : (intervals.get(i).start);
				intervals.remove(i);
				i--;
			}
		}
		return intervals;

	}
	/* Definition for an interval.*/
	 public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }

}

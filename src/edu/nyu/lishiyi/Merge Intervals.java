Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Given intervals => merged intervals:

[                     [
  [1, 3],               [1, 6],
  [2, 6],      =>       [8, 10],
  [8, 10],              [15, 18]
  [15, 18]            ]
]

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> result = new ArrayList();
        if(intervals == null || intervals.size() == 0){
        	return result;
        }

        Comparator<Interval> cmp = new Comparator<Interval> (){

        	public int compare(Interval a, Interval b){
        		return a.start - b.start;
        	}
        };
        Collections.sort(intervals, cmp);

        result.add(intervals.get(0));
        Interval last = intervals.get(0);
        for(Interval interval : intervals){
        	
    		if(interval.start <= last.end){
    			last.end = last.end > interval.end ? last.end : interval.end;
    		}
    		else{
    			last = interval;
    			result.add(last);
    		}
        }
        return result;
    }
}
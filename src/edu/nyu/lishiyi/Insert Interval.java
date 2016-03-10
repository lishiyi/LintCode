Insert Interval

15:00
 Start
Given a non-overlapping interval list which is sorted by start point.

Insert a new interval into it, make sure the list is still in order and 
non-overlapping (merge intervals if necessary).

Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].

Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
        if(intervals == null || intervals.size() == 0){
        	result.add(newInterval);
        	return result;
        }

        int insertPos = 0;
        for(Interval interval : intervals){

        	if(newInterval.end < interval.start){
        		result.add(interval);
        	}
        	else if(newInterval.start >  interval.end){
        		result.add(interval);
        		insertPos += 1;
        	}
        	else{
        		newInterval.start = Math.min(newInterval.start, interval.start);
        		newInterval.end = Math.max(newInterval.end, interval.end);
        	}
        }
        result.add(insertPos, newInterval);
        return result;
    }
}
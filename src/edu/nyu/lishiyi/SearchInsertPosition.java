package edu.nyu.lishiyi;
/**
 * Search Insert Position
 * @author Administrator
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume NO duplicates in the array.

Example
[1,3,5,6], 5 ¡ú 2

[1,3,5,6], 2 ¡ú 1

[1,3,5,6], 7 ¡ú 4

[1,3,5,6], 0 ¡ú 0

Challenge
O(log(n)) time
 */
public class SearchInsertPosition {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
    	
    	if(A == null || A.length == 0){
    		
    		return 0;
    	}
    	
    	
    	if(target <= A[0]){
    		
    		return 0;
    	}
    	
    	int start = 0;
    	int end = A.length - 1;
    	int mid;

    	while(start + 1 < end){
    		
    		mid = start + (end - start) / 2;
    		
    		if(A[mid] == target){
    			
    			return mid;
    		}
    		else if(A[mid] < target){
    			
    			start = mid;
    		}
    		else if(A[mid] > target){
    			
    			end = mid;
    		}
    	}
    	
    	if(A[end] >= target){
    		
    		return end;
    	}
    	if(A[end] < target){
    		
    		return end + 1;
    	}
    	
    	return start;
    }
}

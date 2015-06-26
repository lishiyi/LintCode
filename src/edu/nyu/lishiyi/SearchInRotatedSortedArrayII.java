package edu.nyu.lishiyi;
/**
 * Search in Rotated Sorted Array II
 * @author lishiyi
 *
 */
public class SearchInRotatedSortedArrayII {

    /** 
     * @param A : an integer rotated sorted array and duplicates are allowed
     * @param target :  an integer to be search
     * @return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
    	if(A == null || A.length == 0){
    		
    		return false;
    	}
    	
    	for(int num : A){
    		
    		if( num == target){
    			
    			return true;
    		}
    	}
    	
    	return false;
    }
}

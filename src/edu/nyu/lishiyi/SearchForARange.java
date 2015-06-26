package edu.nyu.lishiyi;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Search for a Range
 * @author Administrator
 *
 */
public class SearchForARange {

	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
    	if(A == null || A.size() == 0){
    		
    		ArrayList<Integer> result = new ArrayList<Integer>(2);
        	result.add(-1);
        	result.add(-1);
    		return result;
    	}
    	
    	ArrayList<Integer> result = new ArrayList<Integer>(2);
    	result.add(startRange(A,target));
    	result.add(endRange(A,target));
    	return result;
    }
    
    private int startRange(ArrayList<Integer> A, int target){
		
    	int start = 0;
    	int end = A.size()-1;
    	int mid;
    	
    	while(start + 1 < end){
    		
    		mid = start + (end - start) / 2;
    		
    		if(A.get(mid) == target){
    			
    			end = mid;
    		}
    		else if(A.get(mid) < target){
    			
    			start = mid;
    		}
    		else if(A.get(mid) > target){
    			
    			end = mid;
    		}
    		
    	}
    	
		if(A.get(start) == target){
			
			return start;
		}
		if(A.get(end) == target){
			
			return end;
		}
    	
    	return -1;
    }
    
    private int endRange(ArrayList<Integer> A, int target){
		
    	int start = 0;
    	int end = A.size()-1;
    	int mid;
    	
    	while(start + 1 < end){
    		
    		mid = start + (end - start) / 2;
    		
    		if(A.get(mid) == target){
    			
    			start = mid;
    		}
    		else if(A.get(mid) < target){
    			
    			start = mid;
    		}
    		else if(A.get(mid) > target){
    			
    			end = mid;
    		}
    		
    	}
    	
		if(A.get(end) == target){
			
			return end;
		}
		if(A.get(start) == target){
			
			return start;
		}
    	
    	return -1;
    }
    
    public static void main(String[] args) {
		
    	SearchForARange sb = new SearchForARange();
    	ArrayList<Integer> a = new ArrayList<Integer>();
    	a.add(-1);
    	a.add(1);
    	a.add(2);
    	a.add(2);
    	a.add(3);
    	a.add(4);
    	
    	ArrayList<Integer> b = new ArrayList<Integer>();
    	System.out.println(sb.searchRange(a, 2));
    	
	}
}

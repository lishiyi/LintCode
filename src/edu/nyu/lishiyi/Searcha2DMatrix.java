package edu.nyu.lishiyi;
/**
 * Search a 2D Matrix
 * @author lishiyi
 *Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example
Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.

Challenge
O(log(n) + log(m)) time
 */
public class Searcha2DMatrix {

    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
    	if(matrix == null || matrix.length == 0){
    		
    		return false;
    	}
    	
    	
    	int start = 0;
    	int end = matrix.length - 1;
    	int mid;
    	
    	while(start + 1 < end){
    		
    		mid = start + (end - start) / 2;
    		
    		if(matrix[mid][0] == target){
    			
    			return true;
    		}
    		else if(matrix[mid][0] < target){
    			
    			start = mid;
    		}
    		else if(matrix[mid][0] > target){
    			
    			end = mid;
    		}
    		
    	}
    	//If target is larger than each row's first element, then search the last row;
    	if(target > matrix[end][0]){
    		
    		start = end;
    	}
    	//Usually, we search from Start line, because the target is : [start][0]  < target < [end][0] 
    	int startIn = 0;
    	int endIn = matrix[start].length - 1;
    	int midIn;
    	
    	while(startIn + 1 < endIn){
    		
    		midIn = startIn + (endIn - startIn) / 2;
    		
    		if(matrix[start][midIn] == target){
    			
    			return true;
    		}
    		else if(matrix[start][midIn] < target){
    			
    			startIn = midIn;
    		}
    		else if(matrix[start][midIn] > target){
    			
    			endIn = midIn;
    		}
    	}
    	
    	if(matrix[start][startIn] == target || matrix[start][endIn] == target){
    		
    		return true;
    	}
    		
    		
    	return false;
    }
}

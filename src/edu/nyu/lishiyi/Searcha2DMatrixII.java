package edu.nyu.lishiyi;
/**
 * Search a 2D Matrix II
 * @author lishiyi
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

    * Integers in each row are sorted from left to right.

    * Integers in each column are sorted from up to bottom.

    * No duplicate integers in each row or column.

Example
Consider the following matrix:

[

    [1, 3, 5, 7],

    [2, 4, 7, 8],

    [3, 5, 9, 10]

]

Given target = 3, return 2.

Challenge
O(m+n) time and O(1) extra space
 */
public class Searcha2DMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
    	if(matrix == null || matrix.length == 0){
    		
    		return 0;
    	}
    	
    	int row = matrix.length - 1;
    	int col = 0;
    	int count = 0;
    	//Move the pointer from bottom-left to top-right
    	while(row >= 0 && col <= matrix[0].length - 1){
    		//If target is larger, thus no more elements in this column can beat target, then move right
    		if(matrix[row][col] < target){
    			
    			col += 1;
    		}
    		else if(matrix[row][col] == target){
    			
    			count += 1;
    			row -= 1;
    		}
    		//If target is smaller, thus there could be elements in this column, move up to search for it. 
    		else if(matrix[row][col] > target){
    			
    			row -= 1;
    		}
    	}
    	
    	
    	return count;
    }
}

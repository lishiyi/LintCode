Triangle

26% Accepted
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Have you met this question in a real interview? Yes
Example
For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here

        if(triangle == null || triangle.size() == 0 ){

        	return 0;
        }

        int n = triangle.size();
        int[][] sum = new int[n][n];

        for(int i = 0; i < n; i++){
        	//The last row. Each one has the value the same as triangle.
        	sum[n - 1][i] = triangle.get(n - 1).get(i);
        }

        //From the second last row:
        for(int i = n - 2; i >= 0; i--){

        	for(int j = 0; j <= i; j++){

        		sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
        	}
        }

        return sum[0][0];
    }
}

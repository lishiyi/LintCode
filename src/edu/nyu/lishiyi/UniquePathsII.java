Unique Paths II

27% Accepted
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Have you met this question in a real interview? Yes
Example
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note
m and n will be at most 100.

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0){

        	return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];
        for(int i = 0; i < m; i++){

        	if(obstacleGrid[i][0] == 0){

        		matrix[i][0] = 1;
        	}
        	else{

        		matrix[i][0] = 0;
        		break;
        	}
        }

        for(int j = 0; j < n; j++){

        	if(obstacleGrid[0][j] == 0){

        		matrix[0][j] = 1;
        	}
        	else{

        		matrix[0][j] = 0;
        		break;
        	}
        	
        }

        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){

        		if(obstacleGrid[i][j] == 1){

        			matrix[i][j] = 0;
        		}
        		else{

        			matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
        		}
        	}
        }

        return matrix[m - 1][n - 1];

    }
}

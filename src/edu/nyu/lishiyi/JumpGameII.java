Jump Game II

33% Accepted
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Have you met this question in a real interview? Yes
Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, 
	then 3 steps to the last index.)

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0){

        	return 0;
        }

        int len = A.length;
        int[] min = new int[len];
        min[0] = 0;

        for(int i = 1; i < len; i++){

        	min[i] = Integer.MAX_VALUE;
        	for(int j = 0; j < i; j++){

        		if(j + A[j] >= i){

        			min[i] = Math.min(min[i], min[j] + 1);
        		}
        	}

        	if(min[i] == Integer.MAX_VALUE){

        		return 0;
        	}
        }

        return min[len - 1];
    }
}

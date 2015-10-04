Minimum Subarray

38% Accepted
Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

Have you met this question in a real interview? Yes
Example
For [1, -1, -2, 1], return -3

Note
The subarray should contain at least one integer.


public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int[] sums = new int[nums.size() + 1];
        sums[0] = 0;
        int max = nums.get(0);
        int result = nums.get(0);
        for(int i = 1; i <= nums.size(); i++){

        	sums[i] = sums[i - 1] + nums.get(i - 1);
        	result = Math.min(result, sums[i] - max);
        	max = Math.max(max, sums[i]);
        }
        return result;
    }
}


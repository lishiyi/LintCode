Maximum Subarray

37% Accepted
Given an array of integers, find a contiguous subarray which has the largest sum.

Have you met this question in a real interview? Yes
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

Note
The subarray should contain at least one number.

Challenge
Can you do it in time complexity O(n)?

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0){
        	return 0;
        }

        int[] sums = new int[nums.size()];
        sums[0] = nums.get(0);
        int max = nums.get(0);
        for(int i = 1; i < nums.size(); i++){
        	sums[i] = Math.max(sums[i - 1] + nums.get(i), nums.get(i));
        	max = Math.max(max, sums[i]);
        }

        return max;
    }
}
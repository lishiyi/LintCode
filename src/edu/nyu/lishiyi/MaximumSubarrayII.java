Maximum Subarray II

24% Accepted
Given an array of integers, find two non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

Have you met this question in a real interview? Yes
Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

Note
The subarray should contain at least one number

Challenge
Can you do it in time complexity O(n) ?


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0){
        	return 0;
        }

        int[] suml = new int[nums.size()];
        suml[0] = nums.get(0);
        for(int i = 1; i < nums.size(); i++){

        	suml[i] = Math.max(suml[i - 1] + nums.get(i), nums.get(i));
        }

        int[] sumr = new int[nums.size()];
        sumr[nums.size() - 1] = nums.get(nums.size() - 1);
        for(int i = nums.size() - 2; i >= 0; i--){

        	sumr[i] = Math.max(sumr[i + 1] + nums.get(i), nums.get(i));
        }

        for(int i = 1; i < nums.size(); i++){

        	suml[i] = Math.max(suml[i], suml[i - 1]);
        	sumr[nums.size() - 1 - i] = Math.max(sumr[nums.size() - 1 - i], sumr[nums.size() - 1 - i + 1]); 
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size() - 1; i++){

        	max = Math.max(max, suml[i] + sumr[i + 1]);
        }

        return max;
    }
}
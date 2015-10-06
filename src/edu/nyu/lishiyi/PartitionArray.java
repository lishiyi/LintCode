Partition Array

25% Accepted
Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") 
such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

Have you met this question in a real interview? Yes
Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

Note
You should do really partition in array nums instead of just counting the numbers of integers 
smaller than k.

If all elements in nums are smaller than k, then return nums.length

Challenge
Can you partition the array in-place and in O(n)?

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums == null || nums.length == 0){
	    	return 0;
	    }
	    int p1 = 0;
	    int p2 = nums.length - 1;
	    while(p1 <= p2){

	    	while(p1 <= p2 && nums[p1] < k){
	    		p1++;
	    	}
	    	while(p1 <= p2 && nums[p2] >= k){
	    		p2--;
	    	}
	    	if(p1 <= p2 && nums[p1] > nums[p2]){
	    		int temp = nums[p2];
	    		nums[p2] = nums[p1];
	    		nums[p1] = temp;
	    		p1++;
	    		p2--;
	    	}
	    }
	    return p1; 
    }
}
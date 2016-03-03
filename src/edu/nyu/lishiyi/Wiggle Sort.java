Wiggle Sort

30:00
 Start
Given an unsorted array nums, reorder it in-place such that

nums[0] <= nums[1] >= nums[2] <= nums[3]....
Have you met this question in a real interview? Yes
 Notice

Please complete the problem in-place.

Example
Tags
Related Problems
 Notes
Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        //Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
        	
        	if( (i % 2 == 0 && nums[i + 1] < nums[i]) || (i % 2 == 1 && nums[i + 1] > nums[i]) ){
        		int temp = nums[i];
        		nums[i] = nums[i + 1];
        		nums[i + 1] = temp;
        	}
        }
    }
}
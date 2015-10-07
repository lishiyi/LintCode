Sort Colors

33% Accepted
Given an array with n objects colored red, white or blue, sort them so that objects of the same 
color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, 
and blue respectively.

Have you met this question in a real interview? Yes
Example
Given [1, 0, 1, 2], return [0, 1, 1, 2].

Note
You are not suppose to use the library's sort function for this problem. '

Challenge
A rather straight forward solution is a two-pass algorithm using counting sort. First, 
iterate the array counting number of 0's, 1's, and 2's, then overwrite array  '
with total number of 0's, then 1's and followed by 2's.     '

Could you come up with an one-pass algorithm using only constant space?

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
        	return;
        }
        int p1 = 0;
        int p2 = nums.length - 1;
        /*3 pointers:

        	p1 for 0s, from left
			p2 for 2s, form right
			i for 1s, swap with p1/p2
		*/
        for(int i = 0; i < nums.length; i++){

        	while(nums[i] == 2 && i < p2){
        		nums[i] = nums[p2];
        		nums[p2] = 2;
        		p2--;
        	}
        	while(nums[i] == 0 && i > p1){
        		nums[i] = nums[p1];
        		nums[p1] = 0;
        		p1++;
        	}
        }
    }
}

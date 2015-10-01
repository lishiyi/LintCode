Majority Number

40% Accepted
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Have you met this question in a real interview? Yes
Example
Given [1, 1, 1, 1, 2, 2, 2], return 1

Challenge
O(n) time and O(1) extra space

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int candidate = 0, count = 0;
        for(int num: nums){

        	if(count == 0){
        		candidate = num;
        		count ++;
        	}
        	else{
	            if(num == candidate){
	        		count ++;
	        	}
	        	else{
	        		count --;
	        	}
        	}

        }
        return candidate;
    }
}

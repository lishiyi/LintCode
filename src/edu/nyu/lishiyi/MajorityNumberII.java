Majority Number II

26% Accepted
Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

Find it.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 1, 2, 1, 3, 3], return 1.

Note
There is only one majority number in the array.

Challenge
O(n) time and O(1) extra space.

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for(int num: nums){

        	if(num == candidate1){
        		count1++;
        	}
        	else if(num == candidate2){
        		count2++;
        	}
        	else if(count1 == 0){
        		candidate1 = num;
        		count1++;
        	}
        	else if(count2 == 0){
        		candidate2 = num;
        		count2++;
        	}
        	else{
        		count1 --;
        		count2 --;
        	}
        }
        count1 = 0;
        count2 = 0;
        for(int num: nums){
        	if(num == candidate1){
        		count1++;
        	}
        	if(num == candidate2){
        		count2++;
        	}
        }

        return count1 > count2 ? candidate1 : candidate2;
    }
}
Single Number III

33% Accepted
Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

Have you met this question in a real interview? Yes
Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge
O(n) time, O(1) extra space.

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        int diff = 0;
        for(int num : A){

        	diff ^= num;
        }
        
        diff = Integer.highestOneBit(diff);
        int group0 = 0, group1 = 0;
        for(int num: A){

        	if((num & diff) == 0){

        		group0 ^= num;
        	}
        	else{

        		group1 ^= num;
        	}
        }

        List<Integer> result = new ArrayList(2);
        result.add(group0);
        result.add(group1);
        return result;
    }
}

3 Sum Closest

30% Accepted
Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
target. Return the sum of the three integers.

Have you met this question in a real interview? Yes
Example
For example, given array S = {-1 2 1 -4}, and target = 1. 
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Note
You may assume that each input would have exactly one solution.

Challenge
O(n^2) time, O(1) extra space

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        if(numbers == null || numbers.length < 3){
        	return 0;
        }
        int result = Integer.MAX_VALUE;
        int len = numbers.length;
        Arrays.sort(numbers);

        for(int i = 0; i < len - 2; i++){

        	if(i != 0 && numbers[i] == numbers[i - 1]){
        		continue;
        	}
        	int p1 = i + 1;
        	int p2 = len - 1;
        	while(p1 < p2){
        		int sum = numbers[i] + numbers[p1] + numbers[p2];
        		if(sum == target){
        			return target;
        		}
        		else if (sum < target){
        			p1++;
        			result = Math.abs(sum - target) < Math.abs(result - target) ? sum : result;
        			while(p1 < p2 && numbers[p1] == numbers[p1 - 1]){
        				p1++;
        			}
        		}
        		else{
        			p2--;
        			result = Math.abs(sum - target) < Math.abs(result - target) ? sum : result;
        			while(p1 < p2 && numbers[p2] == numbers[p2 + 1]){
        				p2--;
        			}
        		}
        	}
        }
        return result;
    }
}
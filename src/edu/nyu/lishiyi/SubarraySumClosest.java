Subarray Sum Closest

16% Accepted
Given an integer array, find a subarray with sum closest to zero. 
Return the indexes of the first number and sums[i - 1] number.

Have you met this question in a real interview? Yes
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]

Challenge
O(nlogn) time

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the sums[i - 1] number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        int[] sums = new int[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap();
        ArrayList<Integer> result = new ArrayList(2);
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
        	sum += nums[i];
        	//Check if it is 0:
        	if(map.containsKey(sum)){
        		result.add(map.get(sum) + 1);
        		result.add(i);
        		return result;
        	}
        	sums[i] = sum;
        	map.put(sum, i);
        }
        sums[nums.length] = 0;
        Arrays.sort(sums);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < sums.length; i++){
        	if(sums[i] - sums[i - 1] <= min){
        		result.clear();
        		result.add(map.get(sums[i - 1]));
        		result.add(map.get(sums[i]));
        		min = sums[i] - sums[i - 1];
        	}
        }

        Collections.sort(result);
        result.set(0, result.get(0) + 1);
        return result;
    }
}
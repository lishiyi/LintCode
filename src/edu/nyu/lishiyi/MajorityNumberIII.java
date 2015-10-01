Majority Number III

26% Accepted
Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.

Find it.

Have you met this question in a real interview? Yes
Example
Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

Note
There is only one majority number in the array.

Challenge
O(n) time and O(k) extra space

import java.util.Map.Entry; 
public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        Map<Integer, Integer> map =  new HashMap(k - 1);
        for(int num : nums){

        	if(map.containsKey(num)){
        		map.put(num, map.get(num) + 1);
        	}
        	else if(map.size() < k - 1){
        		map.put(num, 1);
        	}
        	else{
        		List<Integer> removeList = new ArrayList();
        		for(Entry<Integer, Integer> entry : map.entrySet()){
        			if(entry.getValue() == 1){
        				removeList.add(entry.getKey());
        			}
        			else{
        				map.put(entry.getKey(), entry.getValue() - 1 );
        			}
        		}
        		for(int toRemove : removeList){
        			map.remove(toRemove);
        		}
        	}
        }

        for(Entry<Integer, Integer> entry : map.entrySet()){
        	map.put(entry.getKey(), 0);
        }
        int result = 0, max = 0;
        for(int num : nums){
        	if(map.containsKey(num)){
        		map.put(num, map.get(num) + 1);
        		if(map.get(num) > max){
        			result = num;
        			max = map.get(num);
        		}
        	}
        }
        return result;
    }
}
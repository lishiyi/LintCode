4 Sum

19% Accepted
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.

Have you met this question in a real interview? Yes
Example
For example, given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

(-1, 0, 0, 1)

(-2, -1, 1, 2)

(-2, 0, 0, 2)

Note
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)

The solution set must not contain duplicate quadruplets.

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        //write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        Arrays.sort(numbers);
        int len = numbers.length;

        for(int i = 0; i < len - 3; i++){

        	if(i != 0 && numbers[i] == numbers[i - 1]){
        		continue;
        	}
        	for(int j = i + 1; j < len - 2; j++){

        		if(j != i + 1 && numbers[j] == numbers[j - 1]){
        			continue;
        		}
        		int p1 = j + 1;
        		int p2 = len - 1;
        		while(p1 < p2){
        			int sum = numbers[i] + numbers[j] + numbers[p1] + numbers[p2];
        			if(sum == target){
        				ArrayList<Integer> list = new ArrayList();
        				list.add(numbers[i]);
        				list.add(numbers[j]);
        				list.add(numbers[p1]);
        				list.add(numbers[p2]);
        				//result.add(Arrays.asList(numbers[i], numbers[j], numbers[p1], numbers[p2]));
        				result.add(list);
        				p1++;
        				p2--;
        				while(p1 < p2 && numbers[p1] == numbers[p1 - 1]) p1++;
        				while(p1 < p2 && numbers[p2] == numbers[p2 + 1]) p2--;
        			}
        			else if(sum < target){
        				p1++;
        			}
        			else{
        				p2--;
        			}
        		}
        	}
        }
        return result;
    }
}
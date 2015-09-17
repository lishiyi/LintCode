Combination Sum II

26% Accepted
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Have you met this question in a real interview? Yes
Example
For example, given candidate set 10,1,6,7,2,1,5 and target 8,

A solution set is: 

[1,7]

[1,2,5]

[2,6]

[1,1,6]

Note
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.


public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        //1. Create result for all cases
        List<List<Integer>> result = new ArrayList();
        //2. Create list for one case
        List<Integer> list = new ArrayList();
        //3. Sort
        Arrays.sort(num);
        helper(result, list, num, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, 
    	int[] num, int target, int pos){
    	//4. If target < 0, quit this case.
    	if(target < 0){

    		return;
    	}
    	//5. If target = 0, save this case into result.
    	if(target == 0){

    		result.add(new ArrayList(list));
    		return;
    	}
    	//6. Iterate from current position to the end.
    	for(int i = pos; i < num.length; i++){
    		//7. If dupilicate num(and not the first time we choose), countinue for next
    		// For example [1(1),1(2),1(3),2]: without this line, it will be:
    		//[1(1),2],[1(2),2],[1(3),2], they are all the same.
    		//So we only use the first one. That is [1(1),2]
    		if(i != pos && num[i] == num[i - 1]){

    			continue;
    		}
    		//8. Add this num to list
    		list.add(num[i]);
    		//9. Go on for next
    		helper(result, list, num, target - num[i], i + 1);
    		//10. Backtrack
    		list.remove(list.size() - 1);
    	}
    }
}
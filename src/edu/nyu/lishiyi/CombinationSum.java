Combination Sum

27% Accepted
Given a set of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.



For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

Have you met this question in a real interview? Yes
Example
given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 

Note
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.


public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        //1. Create an array for all cases
        List<List<Integer>> result = new ArrayList();
        //2. Create an array for one case 
        List<Integer> list = new ArrayList();
        //3. Sort the candidates
        Arrays.sort(candidates);
        helper(result, list, candidates, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list,
    	int[] candidates, int target, int pos){
    	//4. If target == 0, that is , calculation complete. Add the case into result
    	if(target == 0){

    		result.add(new ArrayList(list));
    		return;
    	}
    	//5. Iterate all candidates, form current to the end
    	for(int i = pos; i < candidates.length; i++){
    		//6. If this num <= target, put it into the list
    		if(candidates[i] <= target){

    			list.add(candidates[i]);
    			//7. Go on for next, the target - this num.
    			helper(result, list, candidates, target - candidates[i], i);
    			//8. Backtrack
    			list.remove(list.size() - 1);
    		}
    	}
    }
}


Subsets II

24% Accepted
Given a list of numbers that may has duplicate numbers, return all possible subsets

Have you met this question in a real interview? Yes
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Note
Each element in a subset must be in non-descending order.

The ordering between two subsets is free.

The solution set must not contain duplicate subsets.

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        //1. Create a new ArrayList for all cases.
    	ArrayList<ArrayList<Integer>> result = new ArrayList();
    	//2. Create a arraylist for one case
    	ArrayList<Integer> list = new ArrayList();
    	//3. We must sort the S first.
    	Collections.sort(S);
    	helper(result, list, S, 0);
    	return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,
    	ArrayList<Integer> S, int pos){
    	//4. Add one case into the result(At first, it will add [])
    	result.add(new ArrayList(list));
    	//5. We need positon for not using dupicated elements. From postion to the end.
    	for(int i = pos; i < S.size(); i++){
    		//6. If this num is same as the former, and not this time we need. (We must use the first num)
    		//Continue for next.
    		if(i != pos && S.get(i) == S.get(i - 1)){
    			continue;
    		}
    		//7. Add the num into the case
    		list.add(S.get(i));
    		//8. Go on for next positon
    		helper(result, list, S, i + 1);
    		//9. Backtrack
    		list.remove(list.size() - 1);
    	}
    }
}
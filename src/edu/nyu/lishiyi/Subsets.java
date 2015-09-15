Subsets

22% Accepted
Given a set of distinct integers, return all possible subsets.

Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Note
Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        //1. create a result array for all cases;
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        //2. Sort the arraylist for <Set> which can not duplicate.
        Collections.sort(S);
        //3. create a list for one case;
        ArrayList<Integer> list = new ArrayList();
        helper(result, list, S, 0);
        return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
    	ArrayList<Integer> S, int pos){
    	//4. Add the list to the result.(at the 1st time, this is null-set)
    	result.add(new ArrayList(list));
    	//5. For the remaining numbers, from pos to end
    	for(int i = pos; i < S.size(); i++){
    		//6. Add the first num to the list
    		list.add(S.get(i));
    		//7. Go on for the remaining.
    		helper(result, list, S, i + 1);
    		//8. backtrack(DFS)
    		list.remove(list.size() - 1);
    	}
    }
}

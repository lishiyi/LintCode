Permutations

24% Accepted
Given a list of numbers, return all possible permutations.

Have you met this question in a real interview? Yes
Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge
Do it without recursion.

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        //1. Create a result ArrayList for all the cases.
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        if(nums == null || nums.size() == 0){

        	return result;
        }
       	//2. Create a list for each case.
        ArrayList<Integer> list = new ArrayList();
        helper(result, list, nums);
        return result;

    }

    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, 
    	ArrayList<Integer> nums){

    	//3. If the list size == nums, this time complete, add it to result, then return.
    	if(list.size() == nums.size()){

    		result.add(new ArrayList(list));
    		return;
    	}
    	//4. If not, iterate each number
        for(int num : nums){
        	//5. Only if the num not used
        	if(!list.contains(num)){
        		//6. Add this number to list
        		list.add(num);
        		//7. Go on for the remain numbers.
        		helper(result, list, nums);
        		//8. Back track to latest case.(DFS)
        		list.remove(list.size() - 1);
        	}
        }
    }
}


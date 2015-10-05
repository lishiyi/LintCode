3 Sum

19% Accepted
Given an array S of n integers, are there elements a, b, c in S 
such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Have you met this question in a real interview? Yes
Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)
Note
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        //1. Result list
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        int len = numbers.length;
        //2. Sort the numbers first.
        Arrays.sort(numbers);
        //3. For each number
        for(int i = 0; i < len - 2; i++){
        	//4. Delete duplicates
        	if(i != 0 && numbers[i] == numbers[i - 1]){
        		continue;
        	}
        	//5. Like 2-SUM, set the first one as Target
        	int target = 0 - numbers[i];
        	//6. 1st Pointer from i + 1
        	int p1 = i + 1;
        	//7. 2nd pointer form the end
        	int p2 = len - 1;
        	while(p1 < p2){
        		//8. If the sum is smaller, left ->
        		if(numbers[p1] + numbers[p2] < target){
        			p1++;
        		}
        		//9. If the sum is larger,  <- right
        		else if(numbers[p1] + numbers[p2] > target){
        			p2--;
        		}
        		//10. If the sum is the target, save it into result.
        		else if(numbers[p1] + numbers[p2] == target){
        			ArrayList<Integer> list = new ArrayList();
        			list.add(numbers[i]);
        			list.add(numbers[p1]);
        			list.add(numbers[p2]);	
        			result.add(list);
        			//11. Then move on for next case.
        			p1++;
        			p2--;
        			//12. Delete duplicates
        			while(p1 < p2 && numbers[p1] == numbers[p1 - 1]){
        				p1++;
        			}
        			//13. Delete duplicates
        			while(p1 < p2 && numbers[p2] == numbers[p2 + 1]){
        				p2--;
        			}
        		}
        	} 
        }
        return result;
    }
}
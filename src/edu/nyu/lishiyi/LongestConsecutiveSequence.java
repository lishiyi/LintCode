Longest Consecutive Sequence

32% Accepted
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Have you met this question in a real interview? Yes
Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Clarification
Your algorithm should run in O(n) complexity.

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if(num == null){
        	return 0; 
        }
        //1. Creat a hashSet for fast finding
        Set<Integer> hashSet = new HashSet<Integer>();
        int result = 0;
        //2. Put the array into the hashSet
        for(int n : num){

        	hashSet.add(n);
        }
        //3. Iterate all the numbers
        for(int n : num){
        	//4. If not exists(removed from next step), continue
        	if(!hashSet.contains(n)){

        		continue;
        	}
        	//5. At this iteration, the max length
        	int currentMax = 1;
        	//6. Save n, for -- and ++
        	int temp = n;
        	//7. Remove this number when calculated
        	hashSet.remove(n);
        	//8. When there is a number smaller 1 than n, cont it
        	while(hashSet.contains(n - 1)){	

        		currentMax++;
        		hashSet.remove(n - 1);
        		n--;
        	}
        	//10. Recover n.
        	n = temp;
        	//11. When there is a number larger than n
        	while(hashSet.contains(n + 1)){

        		currentMax++;
        		hashSet.remove(n + 1);
        		n++;
        	}
        	result = Math.max(result, currentMax);

        }

        return result;
    }
}
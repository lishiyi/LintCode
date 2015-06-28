/*
Recover Rotated Sorted Array

Given a rotated sorted array, recover it to sorted array in-place.
Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

Challenge
In-place, O(1) extra space and O(n) time.

Clarification
What is rotated array?

For example, the orginal array is [1,2,3,4], 
The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
*/

public class RecoverRotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
    	if(nums == null || nums.size() == 0 || nums.size() == 1){

    		return;
    	}

    	int i = 0;
    	while(i < nums.size() - 1){

    		if(nums.get(i) > nums.get(i + 1)){

    			break;
    		}
    		else{

    			i += 1;
    		}
    	}

    	reverse(nums.subList(0, i + 1));
    	reverse(nums.subList(i + 1, nums.size()));
    	reverse(nums);

    }

    private void reverse(List<Integer> A){

    	for(int start = 0, end = A.size() - 1; start < end; start++, end--){

    		int temp = A.get(start);
    		A.set(start, A.get(end));
    		A.set(end, temp);
    	}
    }
}
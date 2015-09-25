Median

22% Accepted
Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.

Have you met this question in a real interview? Yes
Example
Given [4, 5, 1, 2, 3], return 3

Given [7, 9, 4, 5], return 5

Challenge
O(n) time.

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here

        //1. Create a reveseOrder() compatator, to make head be max 
        //(In PriorityQueue: By default, the head is min) 
        Comparator<Integer> revCmp = Collections.reverseOrder();
        Queue<Integer> leftHeap = new PriorityQueue<Integer>(20, revCmp);
        Queue<Integer> rightHeap = new PriorityQueue<Integer>();

        //2. Iterate all the nums
        for(int num : nums){
        	//3. Add it to the rightHeap first.
        	rightHeap.add(num);
        	//4. If right has 2 numbers more than left, move the smallest in right to left
        	if(rightHeap.size() > leftHeap.size() + 1){

        		leftHeap.add(rightHeap.poll());
        	}
        	//5. If right has 1 number more than left, compare the max of left and min of right,
        	//   if >, swap them.
        	else if(!leftHeap.isEmpty() && rightHeap.size() == leftHeap.size() + 1){

        		if(leftHeap.peek() > rightHeap.peek()){

        			leftHeap.add(rightHeap.poll());
        			rightHeap.add(leftHeap.poll());
        		}
        	}
        }
        if(leftHeap.size() == rightHeap.size()){

        	return leftHeap.peek();
        }
        else{

        	return rightHeap.peek();
        }

    }
}

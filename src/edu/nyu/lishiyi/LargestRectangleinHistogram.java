Largest Rectangle in Histogram

24% Accepted
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
' find the area of largest rectangle in the histogram.

histogram

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

histogram

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Have you met this question in a real interview? Yes
Example
Given height = [2,1,5,6,2,3],
return 10.

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if(height == null){

        	return 0;
        }
        //1. Create a stack for index
        Stack<Integer> stack = new Stack();
        //2. Result number.
        int result = 0;
        //3. Iterate each elements + 1(for calculating the last one)
        for(int i = 0; i <=  height.length; i++){
        	//4. Set the current height. If this is the last time, set it to -1,
        	//   so it shall be smaller than anyone.
        	int current = (i == height.length) ? -1 : height[i];
        	/*
        	   5. If current height <= the latest one, which like 4561, the "6" is certain,
        	   we can calculate the area between 5~1, that is : 
        	   		stack.peek() ~ current i
        	   		    *5            *1      between the 2 numbers. So: 6 * 1 = 6
				
				After the 6 pops, start deal with 5:
					stack.peek() ~ current i        
						*4            *1      between the 2 numbers. So: 5 * 2 = 10

				After the 5 pops, start deal with 4:  But when pop() -> 4, the stack is empty:
					   (0)       ~ current i
					    0             *1       between the 2 numbers.So: 4 * 3 = 12.

				Now the stack is empty, go for next iteration. 4561-1,  -1 < 1, stack: 1,
					when pop() -> 1, the stack is empty:
					   (0)       ~ currrent new i
					    0         height.length 4  between the 2 numbers. So: 1 * 4 = 4.


        	   Normal Stack: 1234567~~
        	*/
        	while(!stack.empty() && current <= height[stack.peek()] ){
        		//6. The height
        		int high = height[stack.pop()];
        		//7. If the stack is empty, the poped one is the min number currently. 
        		//(All Larger numbers already poped before this push.) 
        		int left = stack.empty() ? 0 : stack.peek() + 1;
        		int right = i;
        		int area = high * (right - left);
        		result = Math.max(result, area);
        	}
        	stack.push(i);
        }

        return result;
    }
}
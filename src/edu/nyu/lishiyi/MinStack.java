Min Stack

29% Accepted
Implement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.

Have you met this question in a real interview? Yes
Example
Operations: push(1), pop(), push(2), push(3), min(), push(1), min() Return: 1, 2, 1

Note
min operation will never be called if there is no number in the stack

public class Solution {

	private Stack<Integer> stack;
	private Stack<Integer> minstack;
    
    public Solution() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);

        if(minstack.empty()){

        	minstack.push(number);
        }
        else if(number < minstack.peek()){

        	minstack.push(number);
        }
        else{

        	minstack.push(minstack.peek());
        }
    }

    public int pop() {
        // write your code here
        minstack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minstack.peek();
    }
}

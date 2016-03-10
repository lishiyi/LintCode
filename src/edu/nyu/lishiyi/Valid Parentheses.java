Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

Example
The brackets must close in the correct order, "()" and "()[]{}" are all valid 
but "(]" and "([)]" are not.

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
    	if(s == null || s.length() == 0){
    		return true;
    	}

    	Stack<Character> stack = new Stack<Character>();
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		if(stack.isEmpty() || (c == '(') || (c == '{') || (c == '[')){
    			stack.push(c);
    		}
    		else{
    			if( !isValid(stack.pop(), c) ) return false;
    		}
    	}
    	return stack.isEmpty();
    }

    private boolean isValid(char a, char b){
    	return (a == '[') && (b == ']') || (a == '{') && (b == '}') || (a == '(') && (b == ')');
    }
}
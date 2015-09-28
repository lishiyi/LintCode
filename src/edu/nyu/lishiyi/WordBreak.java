Word Break

12% Accepted
Given a string s and a dictionary of words dict, 
determine if s can be break into a space-separated sequence of one or more dictionary words.

Have you met this question in a real interview? Yes
Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".


public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
    	if(s == null || s.length() == 0){

    		return false;
    	}
    }
}

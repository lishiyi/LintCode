Longest Common Subsequence

37% Accepted
Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.

Have you met this question in a real interview? Yes
Example
For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

For "ABCD" and "EACB", the LCS is "AC", return 2.

Clarification
What's the definition of Longest Common Subsequence?

https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
http://baike.baidu.com/view/2020307.htm
'

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0){

        	return 0;
        }

        //Save the longest length of LCS
        int[][] LCSlength = new int[A.length() + 1][B.length() + 1];


        for(int i = 1; i <= A.length(); i++){

        	for(int j = 1; j <= B.length(); j++){

        		if(A.charAt(i - 1) == B.charAt(j - 1)){

	    			LCSlength[i][j] = LCSlength[i - 1][j - 1] + 1;
    			}
	    		else{

	    			LCSlength[i][j] = Math.max( LCSlength[i][j - 1], LCSlength[i - 1][j] );
	    		}
        	}

        }

        return LCSlength[A.length()][B.length()];
    }
}
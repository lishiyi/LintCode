Edit Distance

29% Accepted
Given two words word1 and word2, find the minimum number of steps required to 
convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Have you met this question in a real interview? Yes
Example
Given word1 = "mart" and word2 = "karma", return 3.


public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        //f[i][j] for first i letters of word1 and first j letters of word2
    	int[][] f = new int[word1.length() + 1][word2.length() + 1];
    	//initialize
    	for(int i = 0; i <= word1.length(); i++){

    		f[i][0] = i;
    	}
    	for(int j = 0; j <= word2.length(); j++){

    		f[0][j] = j;
    	}

    	for(int i = 1; i <= word1.length(); i++){
    		for(int j = 1; j <= word2.length(); j++){

    			if(word1.charAt(i - 1) == word2.charAt(j - 1)){

    				f[i][j] = Math.min( Math.min(f[i - 1][j - 1], f[i - 1][j] + 1) , f[i][j - 1]);
    			}
    			else{

    				f[i][j] = Math.min( Math.min(f[i - 1][j - 1], f[i - 1][j]) , f[i][j - 1]) + 1;
    			}
    		}
    	}

    	return f[word1.length()][word2.length()];

    }
}

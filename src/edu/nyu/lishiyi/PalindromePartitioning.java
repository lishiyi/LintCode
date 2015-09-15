Palindrome Partitioning

22% Accepted


 Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

  public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        //1. Create a ArrayList for all cases
        List<List<String>> result = new ArrayList();
        //2. Create a ArrayList for one case
        List<String> list = new ArrayList();
        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<List<String>> result, List<String> list, String s, int pos){
    	//3. If position == length, that is, the latest we have done one case. Add it to the result
    	if(pos == s.length()){
    		result.add(new ArrayList(list));
    		return;
    	}
    	//4. Create a substring.
    	String substr = "";
    	//5. From this pos to the end
    	for(int i = pos; i < s.length(); i++){
    		//6. First, add this char to the substring
    		substr += s.charAt(i);
    		//7. If this substring is palindrome
    		if(isPalindrome(substr)){
    			//8. Add it to the case.
    			list.add(substr);
    			//9. GO on for next position
    			helper(result, list, s, i + 1);
    			//10. Backtrack
    			list.remove(list.size() - 1);
    		}
    	}
    }

    private boolean isPalindrome(String substr){

    	for(int start = 0, end = substr.length() - 1; start < end; start++, end--){

    		if(substr.charAt(start) != substr.charAt(end)){

    			return false;
    		}
    	}

    	return true;
    }

}

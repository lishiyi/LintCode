/*
Reverse Words in a String

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Example
Clarification
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/
public class ReverseWordsInAString {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if(s == null || s.length() == 0){

        	return s;
        }

        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = array.length - 1; i >= 0; i--){

        	sb.append(array[i]).append(" ");
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);

    }

}
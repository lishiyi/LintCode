Sort Letters by Case

37% Accepted
Given a string which contains only letters. Sort it by lower case first and upper case second.

Have you met this question in a real interview? Yes
Example
For "abAcD", a reasonable answer is "acbAD"

Note
It's not necessary to keep the original order of lower-case letters and upper case letters. '

Challenge
Do it in one-pass and in-place.

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length == 0){
        	return;
        }
        int p1 = 0;
        int p2 = chars.length - 1;
        while(p1 < p2){

        	while(p1 < p2 && chars[p1] >= 'a'){
        		p1++;
        	}
        	while(p1 < p2 && chars[p2] < 'a'){
        		p2--;
        	}
        	if(p1 < p2 && chars[p1] < chars[p2]){
        		char temp = chars[p1];
        		chars[p1] = chars[p2];
        		chars[p2] = temp;
        		p1++;
        		p2--;
        	}
        }
    }
}

Plus One

15:00
 Start
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Have you met this question in a real interview? Yes
Example
Tags
Related Problems
 Notes
Given [1,2,3] which represents 123, return [1,2,4].

Given [9,9,9] which represents 999, return [1,0,0,0].

public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if(digits == null || digits.length == 0){
        	return null;
        }

        int len = digits.length;
        if(digits[len - 1] != 9){
        	digits[len - 1] += 1;
        	return digits;
        }
        digits[len - 1] = 0;
        int carry = 1;
        for(int i = len - 2; i >= 0; i--){
        	digits[i] += carry;
        	carry = 0;
        	if(digits[i] >= 10){
        		digits[i] -= 10;
        		carry = 1;
        	}
        }

        if(carry == 0){
        	return digits;
        }
        else{
        	int[] result = new int[len + 1];
        	result[0] = 1;
        	for(int i = 1; i < len; i++){
        		result[i + 1] = digits[i];
        	}
        	return result;
        }
    }
}
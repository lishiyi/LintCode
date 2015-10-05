Trailing Zeros

29% Accepted
Write an algorithm which computes the number of trailing zeros in n factorial.

Have you met this question in a real interview? Yes
Example
11! = 39916800, so the out should be 2

Challenge
O(log N) time

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        //How many 0s depends on how many "5"s (because 2 is always more than 5)
        int counter = 0;
        while(n > 5){
        	//For each 5, there will be one more "0"
    		counter += n / 5;
    		//If it is 25, there will be two more "0"s, so divide it by 5, for next
    		n /= 5;
        }
        return counter;
    }
};

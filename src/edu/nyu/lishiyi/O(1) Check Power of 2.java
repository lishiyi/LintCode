O(1) Check Power of 2

26% Accepted
Using O(1) time to check whether an integer n is a power of 2.

Have you met this question in a real interview? Yes
Example
For n=4, return true;

For n=5, return false;

Challenge
O(1) time

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        return n > 0 ? ( n & (n - 1) ) == 0 : false; 
    }
};

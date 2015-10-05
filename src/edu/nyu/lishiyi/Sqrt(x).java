Sqrt(x)

23% Accepted
Implement int sqrt(int x).

Compute and return the square root of x.

Have you met this question in a real interview? Yes
Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Challenge
O(log(x))

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        //Newton's fomula: x^n - n = 0
        // x(k+1) = ( x(k) + n / x(k) ) / 2 
        long k = x;
        while(k * k > x){
        	k = (k + n / k) / 2;
        }
        return (int) k;
    }
}
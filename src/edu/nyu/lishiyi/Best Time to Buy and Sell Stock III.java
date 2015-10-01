Best Time to Buy and Sell Stock III

26% Accepted
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Have you met this question in a real interview? Yes
Example
Given an example [4,4,6,1,1,4,2,5], return 6.

Note
You may not engage in multiple transactions at the same time (ie, 
	you must sell the stock before you buy again).

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length <= 1){
        	return 0;
        }

        int min = prices[0];
        int[] left = new int[prices.length];
        for(int i = 1; i < prices.length; i++){

        	min = Math.min(min, prices[i]);
        	left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        int max = prices[prices.length - 1];
        int[] right = new int[prices.length];
        for(int i = prices.length - 2; i >= 0; i--){

        	max = Math.max(max, prices[i]);
        	right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for(int i = 0; i < prices.length; i++){

        	profit = Math.max(profit, left[i] + right[i]);
        } 

        return profit;
    }
};
Best Time to Buy and Sell Stock II

51% Accepted
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Have you met this question in a real interview? Yes
Example
Given an example [2,1,2,0,1], return 2


class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null){
        	return 0;
        }

        int profit = 0;

        for(int i = 0; i < prices.length - 1; i++){
        	//Buy and Sell every day
        	int diff = prices[i + 1] - prices[i];
        	if(diff > 0){
        		profit += diff;
        	}
        }

        return profit;
    }
};
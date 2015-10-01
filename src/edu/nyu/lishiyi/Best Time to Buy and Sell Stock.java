Best Time to Buy and Sell Stock

41% Accepted
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Have you met this question in a real interview? Yes
Example
Given an example [3,2,3,1,2], return 1

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0){
        	return 0;
        }
        int profit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length ; i++){

        	profit = Math.max(profit, prices[i] - min);
        	min = Math.min(min, prices[i]);
        }

        return profit;
    }
}
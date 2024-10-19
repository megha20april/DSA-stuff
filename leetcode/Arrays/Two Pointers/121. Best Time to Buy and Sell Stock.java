// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Easy
// Two pointers, Dynamic Programming, Greedy


// We'll solve it using two pointers
// we'll basically keep track of the minimum buying price
// so far in the array as we iterate through it.
class Solution {
    public int maxProfit(int[] prices) {
        int min = 0;
        int profit = 0;
      // i is basically our selling price index
        for(int i = 1; i < prices.length; i++){
            int profit = prices[i] - prices[min]; // profit at each selling price
            if(profit > maxProfit) maxProfit = profit; // then we update the max profit so far
            if(prices[i] < prices[min]) min = i; // update the minimum buying price so far
        }

        return profit;
    }
}

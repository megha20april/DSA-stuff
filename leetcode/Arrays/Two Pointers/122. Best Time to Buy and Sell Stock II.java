// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
// Medium

======== NOTE: Always solve stock questions by first making a graph diagram as it helps to visualize ==========

// if you'd look at the graph i just mentioned, you'll notice that we just need to calculate all the 
// increases in the price, since that'll lead to the maximum profit for us
  
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}

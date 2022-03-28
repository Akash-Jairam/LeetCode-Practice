class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        
        int profit = 0;
        int sellPrice = prices[prices.length-1];
        
        for(int i = prices.length-2; i >= 0; --i){
            if(prices[i] > sellPrice)
                sellPrice = prices[i];
            else {
                profit = Math.max(profit, sellPrice - prices[i]);
            }
        }
        
        return profit;
    }
}
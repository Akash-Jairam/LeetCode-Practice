class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int currPeak = prices[prices.length - 1];
        for(int i = prices.length -2; i >= 0; --i){
            if(prices[i] < currPeak) 
                max = Math.max(max, currPeak - prices[i]);
            currPeak = Math.max(currPeak, prices[i]);
        }
        
        return max;
    }
}
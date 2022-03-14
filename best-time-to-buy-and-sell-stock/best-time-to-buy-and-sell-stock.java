class Solution {
    public int maxProfit(int[] prices) {
        // Create variables to track lowest price and highest price as well as their indexes (these will be initialized to the last value and index in the array respectively)
        // Create variable for max profit and set to zero
        // Iterate through Array from right to left
        // If we encounter a value that is greater than our current max, we update the max variable and its index. We also check to see if the min index is after our max variable  and update that too
        // If we encounter a value that is lower than our current min, we update the min variable and the min index
        // We calculate our profit at the end of each loop
        int maxProfit = 0;
        int lowestPrice = prices[prices.length-1];
        int highestPrice = prices[prices.length-1];
        int highIndex = prices.length -1;
        
        for(int i = prices.length-1; i >= 0; --i){
            if(prices[i] >= highestPrice){
                highestPrice = prices[i];
                lowestPrice = prices[i];
                highIndex = i;
            }
            
            if(prices[i] < lowestPrice){
                lowestPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit, highestPrice - lowestPrice);
        }
        
        return maxProfit;
    }
}
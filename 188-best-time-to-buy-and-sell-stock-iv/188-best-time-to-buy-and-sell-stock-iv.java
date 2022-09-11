class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] costs = new int[k+1];
        int[] profits = new int[k+1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        profits[0] = 0;
        
        
        for(int price : prices){
            for(int i = 0; i < k; ++i){
                costs[i+1] = Math.min(costs[i+1], price - profits[i]);
                profits[i+1] = Math.max(profits[i+1], price - costs[i+1]);
            }
        }
        
        return profits[k];
    }
}
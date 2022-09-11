class Solution {
    public int maxProfit(int[] prices) {
        int[] cost = new int[3];
        int[] profit = new int[3];
        profit[0] = 0;
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        for(int price : prices){
            for(int i = 0; i < 2; ++i){
                cost[i+1] = Math.min(cost[i+1], price - profit[i]);
                profit[i+1] = Math.max(profit[i+1], price - cost[i+1]);
            }
        }
        
        return profit[2];
    }
}
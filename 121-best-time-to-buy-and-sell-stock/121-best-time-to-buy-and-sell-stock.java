class Solution {
    public int maxProfit(int[] prices) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int profit = 0;
        
        for(int i = 0; i < prices.length; ++i){
            
            Integer buyPrice = null;
            if(!map.isEmpty())
                buyPrice = map.firstKey();
            if(buyPrice != null){
                profit = Math.max(profit, prices[i] - buyPrice);
            }
            map.put(prices[i], i);
        }
        
       return profit;
    }
}
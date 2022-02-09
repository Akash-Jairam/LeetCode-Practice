class Solution {
    public int maxProfit(int[] prices) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y) -> Integer.compare(x,y));
        int profit = 0;
        
        for(int i = 0; i < prices.length; ++i){
            if(!pq.isEmpty())
                profit = Math.max(profit, prices[i] - pq.peek());
            
            pq.add(prices[i]);
        }
        
       return profit;
    }
}
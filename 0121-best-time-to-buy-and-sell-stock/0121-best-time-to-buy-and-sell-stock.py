class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        curr_max = float('-inf')
        max_profit = float('-inf')
        
        for i in range(len(prices)-1, -1, -1):
            curr_max = max(curr_max, prices[i])
            max_profit = max(max_profit, curr_max - prices[i])
        
        return max_profit
        
        
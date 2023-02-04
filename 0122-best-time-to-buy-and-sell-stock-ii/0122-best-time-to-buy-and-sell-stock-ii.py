class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit, curr_stock = 0, prices[0]
        
        for i in range(1, len(prices)):
            if prices[i] > curr_stock:
                profit += prices[i] - curr_stock

            curr_stock = prices[i]
        
        return profit
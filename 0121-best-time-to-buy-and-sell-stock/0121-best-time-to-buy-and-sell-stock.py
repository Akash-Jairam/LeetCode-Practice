class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        highest, res = prices[-1], 0
        i = len(prices) - 2
        
        while i >= 0:
            highest = max(highest, prices[i])
            res = max(res, highest - prices[i])
            i -= 1
            
        return res
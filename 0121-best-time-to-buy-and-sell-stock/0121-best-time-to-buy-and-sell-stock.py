class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        lowest, highest = float('inf'), float('-inf')
        max_p = 0
        for p in prices:
            lowest = min(lowest, p)
           
            max_p = max(max_p, p - lowest)
            
        
        return max_p
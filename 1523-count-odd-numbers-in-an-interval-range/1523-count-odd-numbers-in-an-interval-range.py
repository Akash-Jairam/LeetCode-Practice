class Solution:
    def countOdds(self, low: int, high: int) -> int:
        res = (high - low) // 2 
        
        return 1 + res if low % 2 == 1 or high % 2 == 1 else res
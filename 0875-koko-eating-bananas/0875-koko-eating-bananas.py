class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lo, hi = 1, max(piles)
        res = hi
        
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            
            numHours = 0
            
            for p in piles:
                numHours += math.ceil(p / mid)
                
            
            if numHours <= h:
                res = min(res, mid)
                hi = mid - 1
            else:
                lo = mid + 1
        
        return res
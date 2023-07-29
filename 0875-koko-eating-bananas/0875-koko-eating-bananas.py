class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        total = sum(piles)
        res = 0
        lo, hi = 1, total
        
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            time = 0
            for p in piles:
                time += math.ceil(p / mid)
            
            if time <= h:
                res = min(res, time)
                hi = mid - 1
            else:
                lo = mid + 1
        
        return lo
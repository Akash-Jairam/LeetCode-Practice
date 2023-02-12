class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        res = right
        
        while left <= right:
            mid = left + ((right - left) // 2)
            hours = 0
            
            for p in piles:
                hours += math.ceil(p/mid)
            
            if hours <= h:
                right = mid - 1
                res = min(res, mid)
            else:
                left = mid + 1
        
        return res
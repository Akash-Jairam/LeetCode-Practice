class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lowest, highest = 1, max(piles)
        
        def check(speed):
            num_hours = 0
            
            for p in piles:
                num_hours +=  math.ceil(p / speed)
            
            return num_hours

            
        res = None
        while lowest <= highest:
            mid = lowest + (highest - lowest) // 2
            if check(mid) <= h:
                res = mid
                highest = mid - 1
            else:
                lowest = mid + 1
        
        return res if res else -1
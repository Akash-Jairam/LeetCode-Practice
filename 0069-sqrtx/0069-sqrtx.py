class Solution:
    def mySqrt(self, x: int) -> int:
        l, r = 1, x
        
        while l <= r:
            mid = l + (r-l) // 2
            if mid == x/mid:
                return mid
            elif mid < x/mid:
                l = mid + 1
            else:
                r = mid - 1
        
        return math.floor(r)
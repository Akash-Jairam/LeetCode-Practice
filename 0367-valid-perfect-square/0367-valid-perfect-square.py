class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num < 2:
            return True
        
        l, r = 2, num // 2
        
        while l <= r:
            mid = l + (r - l) // 2
            toCheck = mid * mid
            if toCheck > num:
                r = mid - 1
            elif toCheck < num:
                l = mid + 1
            else:
                return True
        
        return False
class Solution:
    def arrangeCoins(self, n: int) -> int:
        l, r = 0, n
        
        while l <= r:
            k = (l + r )// 2
            curr = k * (k + 1) // 2
            
            if curr == n:
                return k
            
            if n < curr:
                r = k -1
            else:
                l = k + 1
        
        return r
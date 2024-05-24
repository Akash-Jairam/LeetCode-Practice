class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        neg = x < 0
        x = abs(x)
        max_i = (2 ** 31) - 1
        min_i = -(2**31)
        while x:
            prev = res
            res = res * 10 + x % 10
            if not min_i <= res <= max_i: 
                return 0
            x //= 10
        
        return res if not neg else -res
class Solution:
    def isUgly(self, n: int) -> bool:
        if n <= 0:
            return False
        
        factors = [2, 3, 5]
    
        def keep_dividing_when_divisible(dividend, divisor):
                while dividend % divisor == 0:
                    dividend //= divisor

                return dividend
        
        for factor in factors:
            n = keep_dividing_when_divisible(n ,factor)
        
        return n == 1
    
        
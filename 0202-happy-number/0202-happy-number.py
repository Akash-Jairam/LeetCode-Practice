class Solution:
    def isHappy(self, n: int) -> bool:
        prev = set()
        
        while n != 1:
            curr = 0
            while n:
                curr += (n % 10) ** 2
                n //= 10
            
            if curr in prev:
                return False
            
            prev.add(curr)
            n = curr
        
        return n == 1
        
        
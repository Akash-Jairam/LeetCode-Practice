class Solution:
    def numberOfMatches(self, n: int) -> int:
        numMatches = 0
        
        while n > 1:
            if n % 2 == 0:
                numMatches += n // 2
                n //= 2
            else:
                numMatches += (n - 1) // 2
                n = (int)((n - 1) / 2) + 1
        
        return numMatches
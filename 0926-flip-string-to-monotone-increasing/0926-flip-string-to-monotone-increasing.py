class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        res = num = 0
        
        for c in s:
            if c == '0':
                res  = min(num, res + 1)
            else:
                num += 1
        
        return res
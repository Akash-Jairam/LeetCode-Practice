class Solution:
    def maxScore(self, s: str) -> int:
        zeroes, ones = 0, 0
        res = -inf
        
        for i in range(len(s) - 1):
                
            if s[i] == '0':
                zeroes += 1
            
            if s[i] == '1':
                ones += 1
            
            res = max(res, zeroes - ones)
            
        
        if s[-1] == '1':
            ones += 1
        
        return res + ones
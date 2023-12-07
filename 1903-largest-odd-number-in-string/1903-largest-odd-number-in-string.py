class Solution:
    def largestOddNumber(self, num: str) -> str:
        r = len(num) - 1
            
        while r >= 0 and int(num[r]) % 2 == 0:
            r -= 1
        
        if r == 0:
            return num[r]
            
        
        
        
        return "" if r == -1 else num[:r+1]
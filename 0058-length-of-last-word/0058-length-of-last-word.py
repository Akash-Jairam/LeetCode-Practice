class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s = s.strip()
        
        idx = len(s) - 1
        res = 0
        while(idx >= 0 and s[idx] != ' '):
            res += 1
            idx -= 1
        
        return res
        
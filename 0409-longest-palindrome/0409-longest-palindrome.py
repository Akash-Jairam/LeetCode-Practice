from collections import defaultdict
class Solution:
    def longestPalindrome(self, s: str) -> int:
        c_map = defaultdict(int)
        res = 0
        hasMid = 0
        for c in s:
            c_map[c] += 1
        
        for v in c_map.values():
            if v % 2 == 1 and not hasMid:
                hasMid += 1
            
            res += v // 2
        
        return res * 2 + hasMid
            
        
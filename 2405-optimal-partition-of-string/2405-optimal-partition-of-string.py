class Solution:
    def partitionString(self, s: str) -> int:
        curr, res = [0] * 26, 0
        
        for c in s:
            c_val = ord(c) - ord('a')
            if curr[c_val]:
                res += 1
                curr = [0] * 26
            curr[c_val] += 1
            
        return res + 1
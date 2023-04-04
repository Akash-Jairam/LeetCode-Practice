class Solution:
    def partitionString(self, s: str) -> int:
        curr, res = set(), 0
        
        for c in s:
            if c in curr:
                res += 1
                curr = set()
            curr.add(c)
            
        return res + 1
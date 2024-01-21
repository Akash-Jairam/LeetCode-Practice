class Solution:
    def maxDepth(self, s: str) -> int:
        numOpen = 0
        res = 0
        for c in s:
            if c == '(':
                numOpen += 1
            elif c == ')':
                numOpen -= 1
                
            res = max(res, numOpen)
        
        return res
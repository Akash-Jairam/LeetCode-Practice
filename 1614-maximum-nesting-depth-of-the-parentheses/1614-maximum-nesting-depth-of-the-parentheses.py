class Solution:
    def maxDepth(self, s: str) -> int:
        numOpen = 0
        res = float('-inf')
        for c in s:
            if c == '(':
                numOpen += 1
            elif c == ')':
                numOpen -= 1
                
            res = max(numOpen, res)
        
        return res
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res, curr = [], []
        
        def backtrack(numOpen, numClosed):
            if numOpen == numClosed == n:
                res.append(''.join(curr))
                return
            
            if numOpen < n:
                curr.append("(")
                backtrack(numOpen + 1, numClosed)
                curr.pop()
            
            if numClosed < numOpen:
                curr.append(")")
                backtrack(numOpen, numClosed + 1)
                curr.pop()
        
        backtrack(0, 0)
        return res
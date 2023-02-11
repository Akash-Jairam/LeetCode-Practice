class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def backtrack(res, curr, numOpen, numClosed):
            if len(curr) == n*2:
                res.append(curr)
                return
            
            if numOpen < n:
                backtrack(res, curr + '(', numOpen+1, numClosed)
            
            if numClosed < numOpen:
                backtrack(res, curr + ')', numOpen, numClosed + 1)
                
                
        res = []
        backtrack(res, "", 0, 0)
        return res
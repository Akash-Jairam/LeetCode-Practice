class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def backtrack(numOpen, numClosed, res, curr):
            if numOpen == numClosed == n:
                res.append(''.join(curr))
                return
            
            if numOpen < n:
                curr.append('(')
                backtrack(numOpen + 1, numClosed, res, curr)
                curr.pop()
            
            if numClosed < numOpen:
                curr.append(')')
                backtrack(numOpen, numClosed + 1, res, curr)
                curr.pop()
                
        res = []
        backtrack(0, 0, res, [])
        return res
        
    
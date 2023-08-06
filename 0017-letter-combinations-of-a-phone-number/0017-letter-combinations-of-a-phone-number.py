class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        d_map = {'2': 'abc', '3': 'def', '4' : 'ghi', '5' : 'jkl', '6' : 'mno', '7' : 'pqrs', '8' : 'tuv', '9':'wxyz' }
        res = []
        curr = []
        def dfs(i):
            if i >= len(digits):
                res.append(''.join(curr))
                return
            
            n = digits[i]
            for c in d_map[n]:
                curr.append(c)
                dfs(i + 1)
                curr.pop()
        if not digits:
            return res
        dfs(0)
        return res
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        
        def backtrack(curr, idx, total):
            if total == target:
                res.append(curr.copy())
                return
            
            if total > target or idx >= len(candidates):
                return
            
            curr.append(candidates[idx])
            backtrack(curr, idx, total + candidates[idx])
            
            curr.pop()
            backtrack(curr, idx + 1, total)
        
        backtrack([], 0, 0)
        return res
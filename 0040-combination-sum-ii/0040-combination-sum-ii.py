class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        self.backtrack(0, candidates, [], target, res)
        return res
    
    def backtrack(self, i, candidates, curr,target, res):
        if target == 0:
            res.append(curr.copy())
            return
        
        if target < 0 or i >= len(candidates):
            return
        
        prev = float('-inf')
        for j in range(i, len(candidates)):
            if candidates[j] == prev:
                continue
            curr.append(candidates[j])
            self.backtrack(j + 1, candidates, curr, target - candidates[j], res)
            curr.pop()
            prev = candidates[j]
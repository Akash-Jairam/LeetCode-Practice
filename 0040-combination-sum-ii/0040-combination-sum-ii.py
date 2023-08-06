class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        self.backtrack(0, candidates, [], res, target)
        return res
    
    
    def backtrack(self, i, cands, curr, res, target):
        if target == 0:
            res.append(curr[::])
            return
        
        if target < 0 or i >= len(cands):
            return
        
        curr.append(cands[i])
        self.backtrack(i + 1, cands, curr, res, target - cands[i])
        curr.pop()
        
        while i + 1 < len(cands) and cands[i] == cands[i + 1]:
            i += 1
            
        self.backtrack(i + 1, cands, curr, res, target)
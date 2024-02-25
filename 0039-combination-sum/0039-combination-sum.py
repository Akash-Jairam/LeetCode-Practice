class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        self.backtrack(candidates, 0, [], target, res)
        return res
    
    def backtrack(self, cands, index, curr, target, res):
        if target == 0:
            res.append(curr[::])
            return
        
        if target < 0 or index == len(cands):
            return
        
        curr.append(cands[index])
        self.backtrack(cands, index, curr, target - cands[index], res)
        curr.pop()
        
        self.backtrack(cands, index + 1, curr, target, res)
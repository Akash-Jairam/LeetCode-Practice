class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        def backtrack(idx, target, curr):
            if target == 0:
                res.append(curr.copy())
                return
            
            if target < 0:
                return
            
            prev = -1
            
            for i in range(idx, len(candidates)):
                if candidates[i] == prev:
                    continue
                
                curr.append(candidates[i])
                backtrack(i + 1, target - candidates[i], curr)
                curr.pop()
                prev = candidates[i]
        
        backtrack(0, target, [])
        return res
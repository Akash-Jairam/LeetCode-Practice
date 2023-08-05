class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        '''
            Backtrack 
            We have two choices, either take the current number and backtrack from the same position
            Or don't take the current number and backtrack from the next position
            We return if we hit the target, if we are out of bounds or if the curr sum is greater than the target
        '''
        res = []
        self.backtrack(0, candidates, [], 0, target, res)
        return res
        
    
    def backtrack(self, i, candidates, curr, curr_sum, target, res):
        if curr_sum == target:
            res.append(curr.copy())
            return
        
        if curr_sum > target or i >= len(candidates):
            return
        
        curr.append(candidates[i])
        self.backtrack(i, candidates, curr, curr_sum + candidates[i], target, res)
        curr.pop()
        
        self.backtrack(i + 1, candidates, curr, curr_sum, target, res)
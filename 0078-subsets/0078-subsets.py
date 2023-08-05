class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        # Every time we are backtracking, we are presented with two choices: take the current number or don't
        # When we backtrack, append the current number and backtrack
        # Then pop the last number and backtrack again
        # Append a copy of the curr list to res when we can't backtrack anymore
        # Return the res
        res = []
        self.backtrack(0, nums, [], res)
        return res
        
    def backtrack(self, i, nums, curr, res):
        if i >= len(nums):
            res.append(curr.copy())
            return
        
        curr.append(nums[i])
        self.backtrack(i + 1, nums, curr, res)
        
        curr.pop()
        self.backtrack(i + 1, nums, curr, res)
        
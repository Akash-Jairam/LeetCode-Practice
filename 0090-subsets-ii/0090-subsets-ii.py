class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        self.backtrack(0, nums, [], res)
        return res
    
    def backtrack(self, i, nums, curr, res):
        if i == len(nums):
            res.append(curr[::])
            return
        
        curr.append(nums[i])
        self.backtrack(i + 1, nums, curr, res)
        curr.pop()
        
        while i + 1 < len(nums) and nums[i] == nums[i+1]:
            i += 1
        
        self.backtrack(i + 1, nums, curr, res)
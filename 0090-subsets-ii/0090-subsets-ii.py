class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        self.backtrack(0, nums, [], res)
        return res
    
    def backtrack(self, i, nums, subset, res):
        if i >= len(nums):
            res.append(subset[::])
            return
        
        
        # All subsets that include nums[i]
        subset.append(nums[i])
        self.backtrack(i + 1, nums, subset, res)
        subset.pop()
        
        # All subsets that don't include nums[i]
        while i + 1 < len(nums) and nums[i] == nums[i + 1]:
            i += 1
        
        self.backtrack(i + 1, nums, subset, res)
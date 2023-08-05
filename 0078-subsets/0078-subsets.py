class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
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

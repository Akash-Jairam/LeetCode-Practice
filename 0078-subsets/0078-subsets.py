class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtrack(res, 0, nums, [])
        return res
    
    def backtrack(self, res, i, nums, curr):
        if i > len(nums):
            return
        
        res.append(list(curr))
        for j in range(i, len(nums)):
            curr.append(nums[j])
            self.backtrack(res, j + 1, nums, curr)
            curr.pop()
        
        
        
    
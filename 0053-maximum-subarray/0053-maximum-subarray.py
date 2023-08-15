class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr = float('-inf')
        res = float('-inf')
        
        for i in range(len(nums)):
            curr = max(curr + nums[i], nums[i])
            res = max(res, curr)
        
        return res
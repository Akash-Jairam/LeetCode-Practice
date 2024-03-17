class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curr = res = float('-inf')
        
        for num in nums:
            curr = max(curr + num, num)
            res = max(res, curr)
        
        return res
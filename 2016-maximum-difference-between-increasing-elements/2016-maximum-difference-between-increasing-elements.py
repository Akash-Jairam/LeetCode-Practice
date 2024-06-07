class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        mn, res = nums[0],  -1
        
        for n in nums:
            res = max(res, n - mn)
            mn = min(mn, n)
        
        return -1 if not res else res
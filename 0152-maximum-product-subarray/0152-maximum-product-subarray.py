class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        curMin, curMax = 1, 1
        res = nums[0]
        
        for n in nums:
            tmp = curMax * n
            curMax = max(curMin * n, tmp, n)
            curMin = min(curMin * n, tmp, n)
            res = max(res, curMax)
            
        
        return res

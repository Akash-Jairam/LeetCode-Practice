class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        currMin = currMax = 1
        res = nums[0]
        
        for n in nums:
            tmp = currMax * n
            currMax = max(tmp, currMin * n, n)
            currMin = min(tmp, currMin * n, n)
            res = max(res, currMax)
        
        return res
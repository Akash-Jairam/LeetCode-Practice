class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        currMax, currMin = 1, 1
        res = nums[0]
        
        for n in nums:
            tmp = currMax * n
            currMax = max(tmp, currMin * n, n)
            currMin = min(tmp, currMin * n, n)
            res = max(res, currMax, currMin)
        
        return res
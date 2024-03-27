class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        l = 0
        curr = 1
        res = 0
        
        for right, num in enumerate(nums):
            curr *= num
            
            while curr >= k:
                curr //= nums[l]
                l += 1
            
            res += right - l + 1
        
        return res
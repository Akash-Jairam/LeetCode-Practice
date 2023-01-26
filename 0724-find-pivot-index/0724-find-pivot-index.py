class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        total, n = sum(nums), len(nums)
        curr_sum = 0
        
        for i in range(n):
            if curr_sum == (total - nums[i] - curr_sum):
                return i
            curr_sum += nums[i]
            
        
        return -1
class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        max_sum, min_sum, curr_max, curr_min, total = nums[0],nums[0],0,0,0
        
        for num in nums:
            curr_max = max(curr_max + num, num)
            max_sum = max(max_sum, curr_max)
            
            curr_min = min(curr_min + num, num)
            min_sum = min(min_sum, curr_min)
            total += num
        
        return max(max_sum, (total - min_sum)) if max_sum > 0 else max_sum
        
class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        total_nums, total = len(nums), 0
        min_avg, min_idx = sys.maxsize, 0
        curr_total = 0
        
        for num in nums:
            total += num
        
        for i in range(total_nums):
            curr_total += nums[i]
            num1 = curr_total // (i + 1)
            num2 = 0
            if i < total_nums - 1:
                num2 = (total - curr_total) // (total_nums - (i + 1))
            curr_avg = abs(num1 - num2)
            if curr_avg < min_avg:
                min_avg = curr_avg
                min_idx = i
        
        return min_idx
            
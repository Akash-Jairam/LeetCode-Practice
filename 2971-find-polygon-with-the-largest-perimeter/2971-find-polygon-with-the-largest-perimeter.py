class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort()
        prev_sum = 0
        res = -1
        
        for num in nums:
            if num < prev_sum:
                res = num + prev_sum
            
            prev_sum += num
        
        return res
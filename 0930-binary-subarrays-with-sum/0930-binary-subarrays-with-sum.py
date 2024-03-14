class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        curr_sum = 0
        
        freq = {}
        res = 0
        for num in nums:
            curr_sum += num
            if curr_sum == goal:
                res += 1
            
            if curr_sum - goal in freq:
                res += freq[curr_sum - goal]
            
            freq[curr_sum] = 1 + freq.get(curr_sum, 0)
            
        return res
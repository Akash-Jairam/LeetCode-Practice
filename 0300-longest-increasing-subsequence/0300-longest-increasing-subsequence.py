class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        maxLis = [1] * n
        
        for i in range(n - 1, -1, -1):
            for j in range(i, n):
                if nums[i] < nums[j]:
                    maxLis[i] = max(maxLis[i], 1 + maxLis[j])
        
        return max(maxLis)
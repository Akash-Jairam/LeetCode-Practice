class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1] * n
        
        for i in range(n - 1, - 1, -1):
            count = 0
            for j in range(i + 1, n):
                if nums[j] > nums[i]:
                    dp[i] = max(dp[i], 1 + dp[j])
                
        return max(dp)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        return max(self.robHelp(nums[:-1]), self.robHelp(nums[1:]))
        
    def robHelp(self, arr):
        n = len(arr)
        dp = [0] * n
        dp[0] = arr[0]
        if n > 1:
            dp[1] = max(dp[0], arr[1])
        
        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + arr[i])
        
        return dp[-1]
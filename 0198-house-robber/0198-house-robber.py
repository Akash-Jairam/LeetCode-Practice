class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        if n > 1:
            dp[1] = max(nums[0], nums[1])
            
        for i in range(2, n, 1):
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
            
        res = sys.maxsize * -1
        for num in dp:
            res = max(res, num)
        
        
        return res
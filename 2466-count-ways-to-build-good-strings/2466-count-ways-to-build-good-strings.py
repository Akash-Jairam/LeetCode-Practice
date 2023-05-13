class Solution:
    def countGoodStrings(self, low, high, zero, one):
        dp = [0] * (high + 1)
        dp[0] = 1
        res = 0
        mod = int(1e9) + 7

        for i in range(1, high + 1):
            if i >= zero:
                dp[i] = (dp[i] + dp[i - zero]) % mod

            if i >= one:
                dp[i] = (dp[i] + dp[i - one]) % mod

            if i >= low:
                res = (res + dp[i]) % mod

        return res

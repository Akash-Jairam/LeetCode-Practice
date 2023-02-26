class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        if not word1 or not word2:
            return max(len(word1), len(word2))
        
        
        m, n = len(word1), len(word2)
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        
        for i in range(m+1):
            dp[i][0] = i
        
        for j in range(n+1):
            dp[0][j] = j
            
        for i in range(1, m+1):
            c1 = word1[i-1]
            for j in range(1, n+1):
                c2 = word2[j-1]
                if c1 != c2:
                    dp[i][j] = 1 + min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1]))
                else:
                    dp[i][j] = dp[i-1][j-1]
                    
        
        return dp[m][n]
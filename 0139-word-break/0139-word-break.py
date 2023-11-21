class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * len(s)
        
        for i in range(len(s)):
            for word in wordDict:
                n = len(word)
                if i < n - 1:
                    continue
                
                if i == n - 1 or dp[i - n]:
                    if s[i - n + 1 : i+1] == word:
                        dp[i] = True
                        break
        
        return dp[-1]
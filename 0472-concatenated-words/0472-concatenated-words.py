class Solution:
    def findAllConcatenatedWordsInADict(self, words: List[str]) -> List[str]:
        d = set(words)
        memo = {}
        res = []
        
        def dfs(word):
            if word in memo:
                return memo[word]
            
            memo[word] = False
            
            for i in range(1, len(word)):
                prefix = word[:i]
                suffix = word[i:]
                
                if prefix in d and suffix in d:
                    memo[word] = True
                    break
                
                if prefix in d and dfs(suffix):
                    memo[word] = True
                    break
            
            
            return memo[word]
    
        for word in words:
            if dfs(word):
                res.append(word)
        
        return res
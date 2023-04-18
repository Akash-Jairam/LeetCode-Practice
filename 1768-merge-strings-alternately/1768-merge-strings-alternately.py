class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        m, n = len(word1), len(word2)
        i, j = 0, 0
        res = []
        while i < m or j < n:
            c1 = word1[i] if i < m else ""
            c2 = word2[j] if j < n else ""
            
            i += 1
            j += 1
            res.append(c1)
            res.append(c2)
        
        return "".join(res)
            
            
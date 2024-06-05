class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        w_map = [[0] * 26 for _ in range(len(words))]
        res = []
        for i in range(len(words)):
            curr = w_map[i]
            word = words[i]
            for c in word:
                idx = ord(c) - ord('a')
                curr[idx] += 1
        
        for i in range(26):
            hasAll = True
            minCount = float('inf')
            for j in range(len(words)):
                if not w_map[j][i]:
                    hasAll = False
                    break
                minCount = min(minCount, w_map[j][i])
            
            if hasAll:
                for _ in range(minCount):
                    res.append(chr(i + ord('a')))
        
        return res
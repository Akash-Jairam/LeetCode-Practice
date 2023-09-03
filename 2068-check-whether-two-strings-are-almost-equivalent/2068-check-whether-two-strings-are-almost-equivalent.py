class Solution:
    def checkAlmostEquivalent(self, word1: str, word2: str) -> bool:
        w1 = self.countFreq(word1, [0] * 26)
        w2 = self.countFreq(word2, [0] * 26)
        
        for i in range(26):
            if abs(w1[i] - w2[i]) > 3:
                return False
        
        return True
        
    def countFreq(self, s, arr):
        for c in s:
            idx = ord(c) - ord('a')
            arr[idx] += 1
        return arr
class Solution:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        w1Idx, w2Idx = 0, 0
        s1p, s2p = 0, 0
        while w1Idx < len(word1) and w2Idx < len(word2):
            if word1[w1Idx][s1p] != word2[w2Idx][s2p]:
                return False
            s1p += 1
            s2p += 1
            
            if s1p == len(word1[w1Idx]):
                w1Idx += 1
                s1p = 0
            
            if s2p == len(word2[w2Idx]):
                w2Idx += 1
                s2p = 0
        
        return w1Idx == len(word1) and w2Idx == len(word2)
            
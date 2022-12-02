from collections import defaultdict

class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):
            return False
        
        w1Map = defaultdict(int)
        w2Map = defaultdict(int)
        
        for i in range(len(word1)):
            w1Map[word1[i]] += 1
            w2Map[word2[i]] += 1
        
        for c in w1Map.keys():
            if c not in w2Map.keys():
                return False
        
        freq1 = Counter(w1Map.values()) # count freq of each freq 
        freq2 = Counter(w2Map.values())
        
		# check freq counts
        for f, v in freq1.items():
            if freq2[f] != v:
                return False
        
        return True
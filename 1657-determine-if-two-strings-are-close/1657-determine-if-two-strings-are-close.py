from collections import Counter
class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        w1_map = Counter(word1)
        w2_map = Counter(word2)
        
        w1_counter = Counter(w1_map.values())
        w2_counter = Counter(w2_map.values())
        
        for c in w1_map.keys():
            if c not in w2_map:
                return False
        
        for k, v in w1_counter.items():
            if w2_counter[k] != v:
                return False
            
        return True
        

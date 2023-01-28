class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split(" ")
        if len(pattern) != len(words):
            return False
        
        c_map = {}
        w_map = {}
        
        for i in range(len(pattern)):
            c = pattern[i]
            word = words[i]
            
            if c in c_map and c_map[c] != word:
                return False
            
            if word in w_map and w_map[word] != c:
                return False
            
            w_map[word] = c
            c_map[c] = word
        
        return True
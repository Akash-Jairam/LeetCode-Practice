class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        n = len(words)
        c_map = [0] * 26
        
        for word in words:
            for c in word:
                idx = ord(c) - ord('a')
                c_map[idx] += 1
        
        for i in range(26):
            if c_map[i] % n != 0:
                return False
            
        
        return True
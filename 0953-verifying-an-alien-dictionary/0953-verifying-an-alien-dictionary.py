class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        
        a_map = {}
        idx = 0
        
        for c in order:
            a_map[c] = idx
            idx += 1
        
        for i in range(1, len(words)):
            curr, prev = words[i], words[i-1]
            idx = 0
            while idx < min(len(curr), len(prev)) and curr[idx] == prev[idx]:
                idx += 1
            
            
            if idx == len(prev):
                continue
            if idx == len(curr) or a_map[curr[idx]] < a_map[prev[idx]]:
                return False
            
        
        return True
            
            
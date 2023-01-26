from collections import defaultdict
class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        s, c_map, s_map = 'balloon', defaultdict(int), defaultdict(int)
        min_val = sys.maxsize
        for c in text:
            c_map[c] += 1
        
        min_val = sys.maxsize
        for c in s:
            s_map[c] += 1
        
        for c in s_map.keys():
                min_val = min(min_val, c_map[c] // s_map[c])
        
        return min_val
from collections import defaultdict
class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        s, c_map = 'ban', defaultdict(int)
        for c in text:
            c_map[c] += 1
        
        min_val = sys.maxsize
        for c in s:
            min_val = min(min_val, c_map[c])
        
        return min(min_val, min(c_map['l'] // 2, c_map['o'] // 2))
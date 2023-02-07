from collections import defaultdict
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        s_map = defaultdict(int)
        for i in range(len(s) - 9):
            s_map[s[i:i+10]] += 1
        
        return [key for key in s_map if s_map[key] > 1]
            
from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        s_map = defaultdict(list)
        
        for s in strs:
            s_map[self.map_s(s)].append(s)
        
        return s_map.values()
    
    def map_s(self, s):
        c_map = [0] * 26
        
        for c in s:
            i = ord(c) - ord('a')
            c_map[i] += 1
        
        res = []
        for i in range(len(c_map)):
            res.append(str(c_map))
        return ''.join(res)
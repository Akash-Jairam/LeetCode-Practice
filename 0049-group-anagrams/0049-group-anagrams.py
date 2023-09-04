from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        an_map = defaultdict(list)
        for s in strs:
            an_map[self.getAnagram(s)].append(s)
        
        return an_map.values()
        
    
    def getAnagram(self, s):
        c_map = [0] * 26
        
        for c in s:
            i = ord(c) - ord('a')
            c_map[i] += 1
        
        return tuple(c_map)
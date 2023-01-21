from collections import Counter
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        strs_map = defaultdict(list)
        
        for s in strs:
            curr_word = "" + s
            strs_map[''.join(sorted(curr_word))].append(s)
        
        return strs_map.values()
            
        
        
        
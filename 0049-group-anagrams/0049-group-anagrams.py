from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # Count sort the string
        s_map = defaultdict(list)
        
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            # Convert the array to a tuple and use that as a key
            s_map[tuple(count)].append(s)
        
        return s_map.values()
        
        
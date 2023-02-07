from collections import defaultdict
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        # Get every 10 char seq and update its count in a hashmap
        # Return a list of the ones with a count greater than 1
        s_map = defaultdict(int)
        for i in range(len(s) - 9):
            s_map[s[i:i+10]] += 1
        
        return [key for key in s_map if s_map[key] > 1]
            
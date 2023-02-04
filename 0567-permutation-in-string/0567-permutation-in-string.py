class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # Use sliding window with array map
        s1_map, s2_map = [0] * 26, [0] * 26
        m, n = len(s1), len(s2)
        
        for c in s1:
            s1_map[ord(c) - ord('a')] += 1
        
        for i in range(n):
            s2_map[ord(s2[i]) - ord('a')] += 1
            if i >= m:
                s2_map[ord(s2[i - m]) - ord('a')] -= 1
            
            if s1_map == s2_map:
                return True
        
        return False
            
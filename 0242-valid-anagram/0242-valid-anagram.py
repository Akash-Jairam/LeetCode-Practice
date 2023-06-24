class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        n = len(s)
        if len(s) != len(t):
            return False
        
        s_map, t_map = [0] * 26, [0] * 26
        
        for i in range(n):
            s_map[ord(s[i]) - ord('a')] += 1
            t_map[ord(t[i]) - ord('a')] += 1
        
        for i in range(26):
            if s_map[i] != t_map[i]:
                return False
            
        
        return True
            
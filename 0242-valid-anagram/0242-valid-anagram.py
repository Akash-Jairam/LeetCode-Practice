class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False
        s_map = {}
        t_map = {}
        
        for c1, c2 in zip(s, t):
            if c1 in s_map:
                s_map[c1] += 1
            else:
                s_map[c1] = 1
            
            if c2 in t_map:
                t_map[c2] += 1
            else:
                t_map[c2] = 1
        
        for c in s_map.keys():
            if c not in t_map or s_map[c] != t_map[c] :
                return False
            
        return True
        
from collections import defaultdict
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s_map, t_map = defaultdict(str), defaultdict(str)
        
        for i in range(len(s)):
            s_char, t_char = s[i], t[i]
            if not s_map[s_char] and not t_map[t_char]:
                s_map[s_char] = t_char
                t_map[t_char] = s_char
            elif s_map[s_char] != t_char or t_map[t_char] != s_char:
                return False
            
        return True
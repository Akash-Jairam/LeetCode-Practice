from collections import defaultdict
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        def compare(s_m, t_m):
            for k, v in t_m.items():
                if s_m[k] < v:
                    return False
            
            return True
        left = 0
        s_map, t_map = defaultdict(int), defaultdict(int)
        
        for c in t:
            t_map[c] += 1
            
        res = ""
        for right in range(len(s)):
            s_map[s[right]] += 1
            if compare(s_map, t_map):    
                while left <= right and compare(s_map, t_map):
                    curr = s[left:(right+1)]
                    if len(curr) < len(res) or res == "":
                        res = curr
                    s_map[s[left]] -= 1
                    left += 1
                    
        
        return res
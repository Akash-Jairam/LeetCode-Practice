class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "":
            return t
        
        t_map = {}
        for i in range(len(t)):
            t_map[t[i]] = 1 + t_map.get(t[i], 0)
            
        s_map = {}
        res, resLen = [-1, -1], float('inf')
        have, need = 0, len(t)
        l = 0
        
        for r in range(len(s)):
            c = s[r]
            s_map[c] =  1 + s_map.get(c, 0)
            
            if c in t_map and s_map[c] <= t_map[c]:
                have += 1
            
            while have == need:
                if r - l + 1 <= resLen:
                    res = [l, r]
                    resLen = r - l + 1
                
                c = s[l]
                s_map[c] -= 1
                if c in t_map and s_map[c] < t_map[c]:
                    have -= 1
                l += 1
        
        l, r = res
        return s[l : r + 1] if resLen != float('inf') else ""
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        window, t_map = {}, {}
        l, res, reslen = 0, [-1, -1], float('inf')
        have, need = 0, len(t)
        for c in t:
            t_map[c] = 1 + t_map.get(c, 0)
            
        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)
            
            if c in t_map and window[c] <= t_map[c]:
                have += 1
            
            while have == need:
                if r - l + 1 < reslen:
                    reslen = r - l + 1
                    res = [l, r]
                c = s[l]
                window[c] -= 1
                if c in t_map and window[c] < t_map[c]:
                    have -= 1
                
                
                l += 1
            
        l, r = res

        return s[l:r+1] if reslen != float('inf') else ""
                
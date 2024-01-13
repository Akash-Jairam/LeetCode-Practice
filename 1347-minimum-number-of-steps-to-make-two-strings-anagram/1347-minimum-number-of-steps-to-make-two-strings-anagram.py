class Solution:
    def minSteps(self, s: str, t: str) -> int:
        s_map = self.map_s(s)
        t_map = self.map_s(t)
        s_diff, t_diff = 0,0
        
        for i in range(26):
            
            if t_map[i] < s_map[i]:
                t_diff += s_map[i] - t_map[i]
       
        
        return t_diff
    
    def map_s(self, s):
        c_map = [0] * 26
        
        for c in s:
            idx = ord(c) - ord('a')
            c_map[idx] += 1
        
        return c_map
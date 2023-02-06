class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        p_map, s_map = [0] * 26, [0] * 26
        p_len = len(p)
        res = []
        
        for c in p:
            p_map[ord(c) - ord('a')] += 1
        
        for i in range(len(s)):
            s_map[ord(s[i]) - ord('a')] += 1
            if i >= p_len:
                s_map[ord(s[i - p_len]) - ord('a')] -= 1
            
            if s_map == p_map:
                res.append(i- p_len + 1)
        
        return res
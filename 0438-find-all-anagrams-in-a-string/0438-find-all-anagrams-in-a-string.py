class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res, s_map, p_map = [], [0] * 26, [0] * 26
        m = len(p)
        for c in p:
            p_map[ord(c) - ord('a')] += 1
            
        for i in range(len(s)):
            if i >= m:
                s_map[ord(s[i-m]) - ord('a')] -= 1
            
            s_map[ord(s[i]) - ord('a')] += 1
            if s_map == p_map:
                res.append(i - m + 1)
                
        return res
class Solution:
    def longestPalindrome(self, s: str) -> int:
        c_map = {}
        
        for c in s:
            c_map[c] = 1 + c_map.get(c, 0)
         
        half = 0
        mid = 0
        
        for count in c_map.values():
            if not mid and count % 2 == 1:
                mid += 1
            
            half += count // 2
        
        return half * 2 + mid
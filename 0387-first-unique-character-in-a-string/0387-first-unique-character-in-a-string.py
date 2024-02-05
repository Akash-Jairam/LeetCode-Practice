class Solution:
    def firstUniqChar(self, s: str) -> int:
        c_map = [0] * 26
        
        for i in range(len(s)):
            idx = ord(s[i]) - ord('a')
            c_map[idx] += 1
            
        for i in range(len(s)):
            idx = ord(s[i]) - ord('a')
            if c_map[idx] == 1:
                return i
        
        return -1
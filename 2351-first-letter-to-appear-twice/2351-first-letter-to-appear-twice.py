class Solution:
    def repeatedCharacter(self, s: str) -> str:
        c_map = [0] * 26
        
        for c in s:
            idx = ord(c) - ord('a')
            if c_map[idx]:
                return c
            c_map[idx] += 1
        
        return ""
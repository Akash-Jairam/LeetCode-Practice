class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        r_map = self.map_s(ransomNote)
        m_map = self.map_s(magazine)
        
        for i in range(26):
            if r_map[i] > m_map[i]:
                return False
        
        return True
        
    def map_s(self, s):
        arr = [0] * 26
        
        for c in s:
            i = ord(c) - ord('a')
            arr[i] += 1
        
        return arr
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        
        m = len(s1)
        s1_map, s2_map = [0] * 26, [0] * 26
        for i in range(len(s1)):
            s1_map[ord(s1[i]) - ord('a')] += 1
        
        count = 0
        for i in range(len(s2)):
            s2_map[ord(s2[i]) - ord('a')] += 1
            
            count += 1
            
            while count > m:
                s2_map[ord(s2[i-m]) - ord('a')] -= 1
                count -= 1
                
            if s1_map == s2_map:
                return True
        
        return False
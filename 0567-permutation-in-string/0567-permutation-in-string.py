class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # Map s1 characters to their frequencies
        # Iterate through s2 while also doing the same
        # If the window is greater than the length of s1, we slide
        # Compare the maps to each other to verify whether the permutation exists
        # TC: O(N) * 26
        # SC: O(N)
        m = len(s1)
        if m > len(s2):
            return False
        
        s1_map = [0] * 26
        for i in range(m):
            s1_map[ord(s1[i]) - ord('a')] += 1
        
        s2_map = [0] * 26
        l = 0
        for r in range(len(s2)):
            s2_map[ord(s2[r]) - ord('a')] += 1
            
            while r - l + 1 > m:
                s2_map[ord(s2[l]) - ord('a')] -= 1
                l += 1
            if s1_map == s2_map:
                return True
            
        
        return False
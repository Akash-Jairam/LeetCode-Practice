class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        c_map = [0] * 26
        
        for c in s:
            idx = ord(c) - ord('a')
            c_map[idx] += 1
        
        chars = 0
        mid = 0
        for i in range(26):
            if not mid and c_map[i] % 2 == 1:
                mid += 1
            
            chars += c_map[i] // 2
        
        return chars * 2 + mid == len(s)
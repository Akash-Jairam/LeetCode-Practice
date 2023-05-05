class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        max_v, curr_v = 0, 0
        vowels = set('aeiou')
        
        for i in range(k):
            if s[i] in vowels:
                curr_v += 1
        
        max_v = curr_v
        
        for i in range(k, len(s)):
            if s[i-k] in vowels:
                curr_v -= 1
            
            if s[i] in vowels:
                curr_v += 1
            
            max_v = max(max_v, curr_v)
            
        
        return max_v
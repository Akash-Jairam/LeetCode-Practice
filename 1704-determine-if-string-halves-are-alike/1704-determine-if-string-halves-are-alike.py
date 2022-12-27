class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        left_count, right_count = 0, 0
        vowels = 'aeiouAEIOU'
        while left < right:
            if s[left] in vowels:
                left_count += 1
            
            if s[right] in vowels:
                right_count += 1
            left, right = left + 1, right - 1
            
        
        return left_count == right_count
        
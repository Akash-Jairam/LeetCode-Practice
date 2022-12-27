class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        midpt = len(s) // 2
        left, right = s[:midpt], s[midpt:]
        i, left_count, right_count = 0, 0, 0
        vowels = 'aeiouAEIOU'
        while i < midpt:
            if left[i] in vowels:
                left_count += 1
            
            if right[i] in vowels:
                right_count += 1
            
            i += 1
        
        return left_count == right_count
        
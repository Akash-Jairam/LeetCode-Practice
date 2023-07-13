class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = {}
        l, r = 0, 0
        max_f = 0
        
        while r < len(s):
            count[s[r]] = 1 + count.get(s[r], 0)
            max_f = max(max_f, count[s[r]])
            
            if (r - l + 1) - max_f > k:
                count[s[l]] -= 1
                l += 1
            
            r += 1
        
        
        return r - l
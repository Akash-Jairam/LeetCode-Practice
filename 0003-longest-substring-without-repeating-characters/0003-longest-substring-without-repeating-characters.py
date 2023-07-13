class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, r = 0, 0
        curr_chars = set()
        max_l = 0
        
        while r < len(s):
            while s[r] in curr_chars:
                curr_chars.remove(s[l])
                l += 1
            curr_chars.add(s[r])
            max_l = max(max_l, r - l + 1)
            r += 1
        
        return max_l
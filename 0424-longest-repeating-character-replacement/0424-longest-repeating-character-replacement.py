class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # Use sliding window
        # Keep track of when we are within the threshold
        # When outside threshold, increment left and decrement map accordingly
        l, r = 0, 0
        c_map = [0] * 26
        max_char = 0
        res = 0
        while r < len(s):
            c = ord(s[r]) - ord('A')
            c_map[c] += 1
            max_char = max(max_char, c_map[c])
            if r - l + 1 - max_char <= k:
                res = max(res, r - l + 1)
            
            while r - l + 1  - max_char> k:
                c_map[ord(s[l]) - ord('A')] -= 1
                l += 1
                max_char = max(c_map)
            r += 1
        return res
            
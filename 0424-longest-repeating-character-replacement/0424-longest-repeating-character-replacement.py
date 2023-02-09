class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l, r = 0, 0
        c_map = [0] * 26
        res = 0
        while r < len(s):
            c_map[ord(s[r]) - ord('A')] += 1
            max_char = max(c_map)
            if r - l + 1 - max_char <= k:
                res = max(res, r - l + 1)
            else:
                
                while r - l + 1  - max_char> k:
                    c_map[ord(s[l]) - ord('A')] -= 1
                    l += 1
                    max_char = max(c_map)
            r += 1
        return res
            
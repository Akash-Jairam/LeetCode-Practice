class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        c_map = {}
        longest = -1
        
        for i in range(len(s)):
            if s[i] in c_map:
                start = c_map[s[i]]
                longest = max(longest, i - start - 1)
            else:
                c_map[s[i]] = i
        
        return longest
                
class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        c_map = [-1] * 26
        longest = -1
        
        for i in range(len(s)):
            letterIdx = ord(s[i]) - ord('a')
            if c_map[letterIdx] >= 0:
                start = c_map[letterIdx]
                longest = max(longest, i - start - 1)
            else:
                c_map[letterIdx] = i
        
        return longest
                
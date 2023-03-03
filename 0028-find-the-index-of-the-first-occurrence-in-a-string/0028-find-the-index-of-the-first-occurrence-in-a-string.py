class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        idx = 0
        m, n = len(haystack), len(needle)
        
        while idx <= m - n:
            if haystack[idx:idx+n] == needle:
                return idx
            idx += 1
        
        return -1
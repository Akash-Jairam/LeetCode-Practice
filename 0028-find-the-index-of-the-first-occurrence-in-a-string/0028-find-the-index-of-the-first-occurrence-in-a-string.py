class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if haystack == needle:
            return 0
        m, n = len(haystack), len(needle)
        
        for i in range(len(haystack)):
            if haystack[i] == needle[0] and (i + n) <= m and haystack[i:i+n] == needle:
                    return i
        
        return -1
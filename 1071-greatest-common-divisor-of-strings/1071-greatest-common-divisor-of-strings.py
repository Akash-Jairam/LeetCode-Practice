class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        s, i = "", 0
        m, n = len(str1), len(str2)
        max_len = min(m, n)
        res = ""
        
        while len(s) < max_len and i < max_len:
            s += str1[i]
            if s * (m // len(s)) == str1 and s * (n // len(s)) == str2:
                res = s
            i += 1
        
        return res
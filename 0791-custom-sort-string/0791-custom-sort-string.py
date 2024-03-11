class Solution:
    def customSortString(self, order: str, s: str) -> str:
        c_map = [0] * 26
        
        for c in s:
            i = ord(c) - ord('a')
            c_map[i] += 1
        
        
        res = []
        for c in order:
            i = ord(c) - ord('a')
            if c_map[i]:
                res.append(c * c_map[i])
                c_map[i] = 0
        
        for i in range(26):
            if c_map[i]:
                res.append(chr(i + ord('a')) * c_map[i])
        
        return ''.join(res)
class Solution:
    def frequencySort(self, s: str) -> str:
        char_map = {}
        
        for c in s:
            char_map[c] = char_map.setdefault(c, 0) + 1
        
        res = ''
        for k, v in sorted(char_map.items(), key = lambda item: item[1]):
         for i in range(v):
                res = k + res
        
        return res
                
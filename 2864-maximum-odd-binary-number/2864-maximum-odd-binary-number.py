class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        c_map = [0] * 2
        
        for c in s:
            c_map[int(c)] += 1
        
        res = []
        res.append('1' * (c_map[1] - 1))
        res.append('0' * c_map[0])
        res.append('1')
        return ''.join(res)
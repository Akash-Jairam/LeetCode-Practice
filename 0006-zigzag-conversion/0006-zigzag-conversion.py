class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        plot = [[] for x in range(numRows)]
        down = True
        idx = 0
        
        for c in s:
            plot[idx].append(c)
            if down:
                idx += 1
                if idx == numRows:
                    idx -= 2
                    down = False
            else:
                idx -= 1
                if idx == -1:
                    idx += 2
                    down = True
        
        res = []
        for line in plot:
            res.append(''.join(line))
        
        return ''.join(res)
                    
                
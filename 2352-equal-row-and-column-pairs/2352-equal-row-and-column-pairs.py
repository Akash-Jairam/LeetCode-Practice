from collections import defaultdict
class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        row_set = defaultdict(int)
        res = 0
        
        for r in grid:
            row_set[str(r)] += 1
        
        for i in range(len(grid)):
            col = []
            for j in range(len(grid)):
                col.append(grid[j][i])
            
            res += row_set[str(col)]
            
        return res
                
            
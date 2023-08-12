class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        def backtrack(row, col):
            if not 0 <= row < m or not 0 <= col < n or grid[row][col] == '0':
                return
            
            grid[row][col] = '0'
            backtrack(row + 1, col)
            backtrack(row - 1, col)
            backtrack(row , col + 1)
            backtrack(row , col - 1)
            
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    res += 1
                    backtrack(i, j)
        
        return res
            
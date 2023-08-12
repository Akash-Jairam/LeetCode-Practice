class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m,n = len(grid), len(grid[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        res = 0
            
        def dfs(row, col):
            if not 0 <= row < m or not 0 <= col < n or grid[row][col] == 0:
                return 0
                    
            total = 1
            grid[row][col] = 0
            
            for x, y in directions:
                total += dfs(row + x, col + y)
            
            return total
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    res = max(res, dfs(i, j))
        
        return res
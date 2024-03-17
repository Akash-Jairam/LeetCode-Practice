class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(r, c):
            if not 0 <= r < m or not 0 <= c < n or grid[r][c] == '0':
                return
            
            grid[r][c] = '0'
            for x, y in directions:
                dfs(r +x, c + y)
        
        
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        m, n = len(grid), len(grid[0])
        res = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    res += 1
                    dfs(i, j)
        
        return res
class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        m, n = len(heights), len(heights[0])
        pac, atl = set(), set()
        
        def dfs(row, col, prevHeight, visited):
            if not 0 <= row < m or not 0 <= col < n or heights[row][col] < prevHeight or (row, col) in visited:
                return
            
            visited.add((row, col))
            dfs(row + 1, col , heights[row][col], visited)
            dfs(row - 1, col , heights[row][col], visited)
            dfs(row , col + 1, heights[row][col], visited)            
            dfs(row , col - 1, heights[row][col], visited)
            
        for i in range(n):
            dfs(0, i, heights[0][i], pac)
            dfs(m - 1, i, heights[m - 1][i], atl)
        
        for i in range(m):
            dfs(i, 0, heights[i][0], pac)
            dfs(i, n - 1, heights[i][n - 1], atl)
        
        res = []
        for i in range(m):
            for j in range(n):
                curr = (i, j)
                if curr in atl and curr in pac:
                    res.append([i, j])
        
        return res
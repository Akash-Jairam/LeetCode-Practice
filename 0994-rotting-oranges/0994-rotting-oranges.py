from collections import deque
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        res = 0
        m, n = len(grid), len(grid[0])
        fresh = 0
        q = deque()
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh += 1
                
                if grid[i][j] == 2:
                    q.append([i, j])
        numTurns = 0
        
        while q and fresh:
            size = len(q)
            for _ in range(size):
                r, c = q.popleft()
    
                for x, y in directions:
                    if 0 <= r + x < m and 0 <= c + y < n and grid[r + x][c + y] == 1:
                        grid[r + x][c + y] = 2
                        fresh -= 1
                        q.append([r + x, c + y])
            numTurns += 1
            
        return numTurns if not fresh else -1
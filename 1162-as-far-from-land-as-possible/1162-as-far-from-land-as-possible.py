from collections import deque
class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        queue = deque()
        res = 0
        m, n = len(grid), len(grid[0])
        directions = [[0, -1], [0, 1], [-1, 0], [1, 0]]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    queue.append([i, j])
        
        if not queue or len(queue) == m * n:
            return -1
        
        visited = set()
        while queue:
            size = len(queue)
            for _ in range(size):
                r, c = queue.popleft()
                for up, down in directions:
                    curr_r = r + up
                    curr_c = c + down
                    if m > curr_r >= 0 <= curr_c < n and grid[curr_r][curr_c] == 0 and (curr_r, curr_c) not in visited:
                        queue.append([curr_r, curr_c])
                        visited.add((curr_r, curr_c))
            
            res += 1
        
        return res - 1
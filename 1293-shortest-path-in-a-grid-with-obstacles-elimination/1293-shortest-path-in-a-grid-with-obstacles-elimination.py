from collections import deque
class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        queue = deque()
        visited = set()
        m = len(grid)
        n = len(grid[0])
        
        directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        queue.append((0, 0, k))
        visited.add((0, 0, k))
        steps = 0
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if curr[0] == m - 1 and curr[1] == n - 1:
                    return steps
                
                for dir in directions:
                    row = curr[0] + dir[0]
                    col = curr[1] + dir[1]
                    curr_k = curr[2]
                    if row >= 0 and row < m and col >= 0 and col < n:
                        curr_k -= grid[row][col]
                        candidate = (row, col, curr_k)
                        if curr_k >= 0 and candidate not in visited:
                            visited.add(candidate)
                            queue.append(candidate)
        
            steps += 1
        return -1
                
        
from collections import deque
class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        m, n = len(rooms), len(rooms[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        INF = float('inf')
        q = deque()
        visited = set()
        for i in range(m):
            for j in range(n):
                if rooms[i][j] == 0:
                    q.append((i, j, 0))
        
        while q:
            size = len(q)
            for _ in range(size):
                r, c, steps = q.popleft()
                rooms[r][c] = min(rooms[r][c], steps)
                visited.add((r, c))
                for x, y in directions:
                    nxt_r, nxt_c = r + x, c + y
                    if 0 <= nxt_r < m and 0 <= nxt_c < n and rooms[nxt_r][nxt_c] != -1 and (nxt_r, nxt_c) not in visited:
                        q.append((nxt_r, nxt_c, steps + 1))
        
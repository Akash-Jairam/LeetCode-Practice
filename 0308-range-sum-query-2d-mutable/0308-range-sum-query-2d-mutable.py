from collections import deque
class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.matrix = matrix
        self.dirs = [[0, 1], [1, 0]]
        
    def update(self, row: int, col: int, val: int) -> None:
        self.matrix[row][col] = val

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        q = deque()
        q.append((row1, col1))
        total = 0
        visited = set()
        while q:
            size = len(q)
            for _ in range(size):
                x, y = q.popleft()
                total += self.matrix[x][y]
                for i, j in self.dirs:
                    if x + i <= row2 and y + j <= col2 and (x + i, y + j) not in visited:
                        visited.add((x + i, y + j))
                        q.append((x + i, y + j))
        
        return total

# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# obj.update(row,col,val)
# param_2 = obj.sumRegion(row1,col1,row2,col2)
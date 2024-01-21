from collections import deque
class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.matrix = matrix

    def update(self, row: int, col: int, val: int) -> None:
        self.matrix[row][col] = val

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        visited = set()
        directions = [[1, 0], [0, 1]]
        q = deque()
        q.append((row1, col1))
        res = 0
        while q:
            size = len(q)
            for _ in range(size):
                x, y = q.popleft()
                res += self.matrix[x][y]
                for d in directions:
                    row = x + d[0]
                    col = y + d[1]
                    if row <= row2 and col <= col2 and not (row, col) in visited:
                        visited.add((row, col))
                        q.append((row, col))
        return res
# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# obj.update(row,col,val)
# param_2 = obj.sumRegion(row1,col1,row2,col2)
class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        res = []
        for i in range(len(grid[0])):
            row, col = 0, i
            while row < m and col < n:
                if grid[row][col] == 1 and col < n - 1 and grid[row][col + 1] == 1:
                    row += 1
                    col += 1
                elif grid[row][col] == -1 and col > 0 and grid[row][col-1] == -1:
                    row += 1
                    col -= 1
                else:
                    break
            if row == m:
                res.append(col)
            else:
                res.append(-1)
                
        
        return res
                    
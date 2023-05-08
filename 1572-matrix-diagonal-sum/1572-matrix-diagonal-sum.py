class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        visited = set()
        res = [0]
        
        def dfs(row, col, direction):
            if row < 0 or row >= m or col < 0 or col >= n:
                return
            
            
            if (row, col) not in visited:
                res[0] += mat[row][col]
            
            visited.add((row, col))
            
            if direction == 'R':
                dfs(row + 1, col + 1, direction)
            else:
                dfs(row + 1, col - 1, direction)
            
        dfs(0, 0, 'R')
        dfs(0, n - 1, 'L')
        
        return res[0]
    
        
        
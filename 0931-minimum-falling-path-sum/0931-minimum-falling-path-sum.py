class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len(matrix)
        paths = [0] * m
        
        for i in range(1, m):
            for j in range(m):
                matrix[i][j] += min(matrix[i-1][max(0,j-1)], min(matrix[i-1][j], matrix[i-1][min(m-1, j+1)]))
        
        min_val = sys.maxsize
        for i in range(m):
            min_val = min(min_val, matrix[m-1][i])
        
        return min_val
        
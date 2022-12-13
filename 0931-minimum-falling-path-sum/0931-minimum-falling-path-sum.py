class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        paths = [0] * n
        
        for i in range(1, m):
            for j in range(n):
                matrix[i][j] += min(matrix[i-1][max(0,j-1)], min(matrix[i-1][j], matrix[i-1][min(n-1, j+1)]))
        
        min_val = sys.maxsize
        for i in range(n):
            min_val = min(min_val, matrix[m-1][i])
        
        return min_val
        
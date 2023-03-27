class Solution:
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])
        pre = [grid[0][0]] * m
        cur = [0] * m
        for i in range(1, m):
            pre[i] = pre[i - 1] + grid[i][0]
        for j in range(1, n):
            cur[0] = pre[0] + grid[0][j]
            for i in range(1, m):
                cur[i] = min(cur[i - 1], pre[i]) + grid[i][j]
            pre, cur = cur, pre
        return pre[m - 1]

class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        m, n = len(land), len(land[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        
        res = []
        def dfs(r, c, curr):
            if not 0 <= r < m or not 0 <= c < n or land[r][c] == 0:
                return 
            
            curr[0] = min(curr[0], r)
            curr[1] = min(curr[1], c)
            curr[2] = max(curr[2], r)
            curr[3] = max(curr[3], c)
            
            land[r][c] = 0
            for x, y in dirs:
                dfs(r +x, c + y, curr)
                
        
        for i in range(m):
            for j in range(n):
                if land[i][j]:
                    tmp = [float('inf'), float('inf'), float('-inf'), float('-inf')]
                    dfs(i, j, tmp)
                    res.append(tmp)
                    
        return res
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        def dfs(idx, row, col):
            if idx >= len(word):
                return True
            
            if row < 0 or row >= m or col < 0 or col >=n:
                return False
            
            if board[row][col] != word[idx]:
                return False
            
            c = board[row][col]
            board[row][col] = ' '
            
            res = (dfs(idx + 1, row - 1, col) or
                    dfs(idx + 1, row + 1, col) or
                    dfs(idx + 1, row, col - 1) or   
                    dfs(idx + 1, row, col + 1) )
            board[row][col] = c
            return res
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if dfs(0, i, j):
                        return True
        
        return False
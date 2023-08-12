class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])
        def capture(row, col):
            if not 0 <= row < m or not 0 <= col < n or board[row][col] != 'O':
                return
            
            board[row][col] = 'T'
            capture(row + 1, col )
            capture(row - 1, col )
            capture(row , col + 1)
            capture(row , col - 1)
            
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O' and (i in [0, m-1] or j in [0, n -1]):
                    capture(i, j)
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                    
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'T':
                    board[i][j] = 'O'
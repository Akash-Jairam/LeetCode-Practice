class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        
        def dfs(r, c, idx):
            if not 0 <= r < m or not 0 <= c < n or board[r][c] == '*':
                return False
            
            curr = board[r][c]
            if curr != word[idx]:
                return False
            
            idx += 1
            if idx == len(word):
                return True
            board[r][c] = '*'
            
            found = dfs(r + 1, c, idx) or dfs(r - 1, c, idx) or dfs(r, c+1, idx) or dfs(r, c - 1, idx)
            
            board[r][c] = curr
            return found
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0] and dfs(i, j, 0):
                    return True
                
        return False
        
        
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0] and self.backtrack(i, j, board, 0, word):
                    return True
        
        return False
    
    def backtrack(self, r, c, board, idx, word):
        if not 0 <= r < len(board) or not 0 <= c < len(board[0]) or board[r][c] != word[idx]:
            return False
        
        idx += 1
        if idx == len(word):
            return True
        
        curr = board[r][c]
        board[r][c] = None
        
        res = self.backtrack(r + 1, c, board, idx, word) or self.backtrack(r - 1, c, board, idx, word) or self.backtrack(r , c + 1, board, idx, word) or self.backtrack(r , c - 1, board, idx, word)
        board[r][c] = curr
        return res
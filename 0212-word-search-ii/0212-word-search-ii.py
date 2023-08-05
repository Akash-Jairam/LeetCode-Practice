class Solution:
    class Node:
        def __init__(self):
            self.children = {}
            self.word = None
    
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = self.Node()
        res = []
        for word in words:
            it = root
            for c in word:
                it.children[c] = it.children.get(c, self.Node())
                it = it.children[c]
            it.word = word
        
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                c = board[i][j]
                if root.children.get(c, None):
                    self.dfs(i, j, root, res, board)
        
        return res
    
    def dfs(self, r, c, node, res, board):
        if not 0 <= r < len(board) or not 0 <= c < len(board[0]) or not board[r][c]:
            return
        
        curr_char = board[r][c]
        child = node.children.get(curr_char, None)
        if not child:
            return
        
        if child.word:
            res.append(child.word)
            child.word = None
        
        board[r][c] = None
        self.dfs(r + 1 , c, child, res, board)
        self.dfs(r , c + 1, child, res, board)
        self.dfs(r - 1 , c, child, res, board)
        self.dfs(r , c - 1, child, res, board)
        board[r][c] = curr_char
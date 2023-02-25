class Solution:
    class Node:
        def __init__(self):
            self.children = [None] * 26
            self.word = None
            
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        m, n = len(board), len(board[0])
        directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        root = self.Node()
        res = []
        
        def dfs(curr_node, i, j, board):
            if i < 0 or i >= m  or j < 0 or j >= n or not board[i][j] or len(res) == len(words):
                return
            
            c = board[i][j]
            curr_idx = ord(c) - ord('a')
            if not curr_node.children[curr_idx]:
                return
            
            curr_node = curr_node.children[curr_idx]
            if curr_node.word:
                res.append(curr_node.word)
                curr_node.word = None
                
            
            
            board[i][j] = None
            for d in directions:
                dfs(curr_node, i + d[0], j + d[1], board)
            
            board[i][j] = c
            
           
            
        
        
        for word in words:
            it = root
            for c in word:
                idx = ord(c) - ord('a')
                if not it.children[idx]:
                    it.children[idx] = self.Node()
                it = it.children[idx]
            it.word = word
        
        for row in range(m):
            for col in range(n):
                val = ord(board[row][col]) - ord('a')
                if root.children[val]:
                    dfs(root, row, col, board)
        
        return res
        
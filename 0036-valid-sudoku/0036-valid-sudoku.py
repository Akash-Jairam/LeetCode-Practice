class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = collections.defaultdict(set)
        cols = collections.defaultdict(set)
        boxes = collections.defaultdict(set)
        n = len(board)
        
        for r in range(n):
            for col in range(n):
                c = board[r][col]
                
                if c == '.':
                    continue
                
                if c in rows[r] or c in cols[col] or c in boxes[(r // 3, col // 3)]:
                    return False
                
                rows[r].add(c)
                cols[col].add(c)
                boxes[(r // 3, col // 3)].add(c)
        
        return True
        
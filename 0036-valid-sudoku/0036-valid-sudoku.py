class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = len(board)

        for i in range(n):
            row = set()
            col = set()
            diag = set()
            for j in range(n):
                curr_row_val = board[i][j]
                curr_col_val = board[j][i]
                curr_diag_val = board[(i // 3) * 3 + (j // 3) ][(i % 3 ) * 3 + (j % 3)]
                
                if curr_row_val not in row:
                    row.add(curr_row_val)
                elif curr_row_val != '.':
                    return False
               
                if curr_col_val not in col:
                    col.add(curr_col_val)
                elif curr_col_val != '.':
                    return False
                
                if curr_diag_val not in diag:
                    diag.add(curr_diag_val)
                elif curr_diag_val != '.':
                    return False
        
        return True
        
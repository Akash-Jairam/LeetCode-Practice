class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        left, right, up, down = 0, len(matrix[0]) - 1, 0, len(matrix) - 1
        d = 'R'
        res = []
        while left <= right and up <= down:
            if d == 'R':
                for i in range(left, right+1):
                    res.append(matrix[up][i])
                up += 1
                d = 'D'
            elif d == 'D':
                for i in range(up, down + 1):
                    res.append(matrix[i][right])
                right -= 1
                d = 'L'
            elif d == 'L':
                i = right
                while i >= left:
                    res.append(matrix[down][i])
                    i -= 1
                down -= 1
                d = 'U'
            else:
                i = down
                while i >= up:
                    res.append(matrix[i][left])
                    i -= 1
                left += 1
                d = 'R'
                
        return res
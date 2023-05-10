class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        up, down, left, right = 0, n - 1, 0, n - 1
        num = 1
        d = 'R'
        res = [[0] * n for i in range(n)]
        while left <= right and up <= down:
            if d == 'R':
                for i in range(left, right + 1):
                    res[up][i] = num
                    num += 1
                up += 1
                d = 'D'
            elif d == 'D':
                for i in range(up, down + 1):
                    res[i][right] = num
                    num += 1
                right -= 1
                d = 'L'
            elif d == 'L':
                i = right
                while i >= left:
                    res[down][i] = num
                    num += 1
                    i -= 1
                down -= 1
                d = 'U'
            else:
                i = down
                while i >= up:
                    res[i][left] = num
                    num += 1
                    i -= 1
                left += 1
                d = 'R'
        return res
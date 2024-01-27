class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]
        for i in range(2, numRows + 1):
            curr = []
            for j in range(i):
                left = 0 if j - 1 < 0 else res[-1][j-1]
                right = 0 if j + 1 > len(res[-1]) else res[-1][j]
                curr.append(left + right)
            res.append(curr)
        
        return res
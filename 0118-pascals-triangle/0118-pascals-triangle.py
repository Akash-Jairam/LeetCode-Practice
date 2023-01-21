class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]
        
        for i in range(2, numRows+1):
            prev = res[-1]
            new = [1]
            for j in range(1, i-1):
                left = prev[j-1] if j > 0 else 0
                right = prev[j] 
                new.append(left + right)
            new.append(1)
            res.append(new)
        
        return res
                
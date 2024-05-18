class Solution:
    def sumZero(self, n: int) -> List[int]:
        if n == 1:
            return [0]
        
        res = []
        total = 0
        for i in range(1, n):
            res.append(i)
            total += i
        
        res.append(-total)
        return res
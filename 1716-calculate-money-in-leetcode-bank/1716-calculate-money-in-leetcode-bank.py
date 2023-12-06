class Solution:
    def totalMoney(self, n: int) -> int:
        curr = 1
        res = 0
        for i in  range(n // 7):
            for j in range(curr, curr + 7):
                res += j
            curr += 1
        
        
        for i in range(curr, curr + n % 7):
            res += i
        
        return res
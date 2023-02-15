class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        n1 = num[0]
        
        for i in range(1, len(num)):
            n1 = n1 * 10 + num[i]
            
        
        n1 += k
        res = []
        
        while n1 > 0:
            res.append(n1 % 10)
            n1 //= 10
        
        return res[::-1] if res else [0]
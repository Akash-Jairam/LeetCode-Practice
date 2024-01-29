class Solution:
    def isHappy(self, n: int) -> bool:
        prev = set()
        temp = n
        while temp != 1:
            curr = 0
            while temp:
                curr = curr +  (temp % 10) ** 2
                temp //= 10
            if curr in prev:
                return False
            prev.add(curr)
            temp = curr
        
        return True
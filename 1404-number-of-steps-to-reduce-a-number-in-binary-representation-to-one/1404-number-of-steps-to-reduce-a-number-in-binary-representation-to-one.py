class Solution:
    def numSteps(self, s: str) -> int:
        n = len(s)
        steps, carry = 0, 0
        
        for i in range(n - 1, 0, -1):
            digit = int(s[i]) + carry
            if digit % 2 == 1:
                steps += 2
                carry = 1
            else:
                steps +=1
            
        return steps + carry
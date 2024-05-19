class Solution:
    def checkValidString(self, s: str) -> bool:
        leftMin = leftMax = 0
        
        for c in s:
            if c == '(':
                leftMin, leftMax = leftMin + 1, leftMax + 1
            elif c == ')':
                leftMin, leftMax = leftMin - 1, leftMax - 1
            elif c == '*':
                leftMin = leftMin - 1
                leftMax = leftMax + 1
            
            if leftMin < 0:
                leftMin = 0
            
            if leftMax < 0:
                return False
        
        return leftMin == 0
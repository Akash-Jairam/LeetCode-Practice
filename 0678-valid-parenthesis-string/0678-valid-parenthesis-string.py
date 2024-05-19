class Solution:
    def checkValidString(self, s: str) -> bool:
        # Use two variables to keep track of the min and max opening braces
        # When we encounter an opening brace, we increase the variables
        # When we encounter a closing brace, we decrease them
        # When we encounter a *, we decrease the leftMin and increase the leftMax per their names
        # If the leftMin < 0, we reset to 0 to account for the * being an empty string
        # If the leftMax < 0, we return False because that means there are more closing braces than the max possible number of open braces
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
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        # Iterate through heights
        # Set the initial start point to i
        # While there are heights on the stack that are greater than the current height
        # Pop them off and calculate their height since this is as far that they will go
        # Update the start value since the current value can extend backwards
        # After the loop is finished, pop off the remainder of the stack and calculate their values
        # Relative to the length of the array
        
        maxArea = 0
        stack = []
        
        for i in range(len(heights)):
            start = i
            
            while stack and stack[-1][0] > heights[i]:
                prev_h, prev_i = stack.pop()
                maxArea = max(maxArea, prev_h * (i - prev_i))
                start = prev_i
            
            stack.append((heights[i], start))
        
        n = len(heights)
        while stack:
            h, i = stack.pop()
            maxArea = max(maxArea, h * (n - i))
        
        return maxArea
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
        n = len(heights)
        
        for i in range(n):
            start = i
            while stack and stack[-1][1] > heights[i]:
                prev_i, prev_h = stack.pop()
                maxArea = max(maxArea, (i - prev_i) * prev_h)
                start = prev_i
            
            stack.append((start, heights[i]))
        
        while stack:
            i, h = stack.pop()
            maxArea = max(maxArea, (n - i) * h)
        
        return maxArea
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
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
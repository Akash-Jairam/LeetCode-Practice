class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_h = 0
        l, r = 0, len(height) - 1
        
        while l < r:
            curr = min(height[l], height[r]) * (r - l)
            max_h = max(max_h, curr)
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        
        return max_h
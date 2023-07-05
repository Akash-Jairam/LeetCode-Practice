class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_a = 0
        l, r = 0, len(height) - 1
        max_h = max(height)
        while l < r:
            curr = min(height[l], height[r]) * (r - l)
            max_a = max(max_a, curr)
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
            
            if (r - l) * max_h <= max_a:
                break
        
        return max_a
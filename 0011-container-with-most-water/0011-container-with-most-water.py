class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right, res = 0, len(height) -1, 0
        
        while left < right:
            lh, rh = height[left],  height[right]
            res = max(res, min(lh, rh) * (right - left))
            if lh > rh:
                right -= 1
            else:
                left += 1
        
        return res
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        maxLeft, maxRight = height[0], height[n-1]
        left, right = 0, n-1
        res = 0
        
        while left < right :
            if maxLeft > maxRight:
                res += max(0, min(maxLeft, maxRight) - height[right])
                right -= 1
                maxRight = max(maxRight, height[right])
            else:
                res += max(0, min(maxLeft, maxRight) - height[left])
                left += 1
                maxLeft = max(maxLeft, height[left])
            
        return res
class Solution:
    def trap(self, height: List[int]) -> int:
        #Use sliding window to get the maxLeft and maxRight
        #Slide the lesser of the maxleft and maxright
        #Before sliding subtract the height of the current right or left
        #from the min of the maxes
        #Add the diff to res
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
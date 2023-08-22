class Solution:
    def jump(self, nums: List[int]) -> int:
        l, r = 0, 0
        steps = 0
        
        while r < len(nums) - 1:
            maxSteps = 0
            for i in range(l, r + 1):
                maxSteps = max(maxSteps, i + nums[i])
            
            l = r + 1
            r = maxSteps
            steps += 1
        
        return steps
            
            
        
        